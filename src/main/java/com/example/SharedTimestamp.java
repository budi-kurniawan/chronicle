package com.example;

import static com.example.Constants.LOCK_KEY;
import static com.example.Constants.LOCK_VALUE;
import static com.example.Constants.TIMESTAMP_KEY;

import java.io.File;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;

public class SharedTimestamp {
	
	private ChronicleMap<Long, Long> map;
	
	public SharedTimestamp() {
		init();
	}
	
	public long timestamp() {
		int i = 0;
		while (true) {
			
			boolean success = map.remove(LOCK_KEY, LOCK_VALUE); // atomic operation
			if (success) {
				long oldTs = map.get(TIMESTAMP_KEY);
				long ts = System.currentTimeMillis() * 1000; // microseconds
				if (oldTs >= ts) {
					ts = oldTs + 1;
				}
				map.put(TIMESTAMP_KEY, Long.valueOf(ts));
				map.put(LOCK_KEY, LOCK_VALUE);
				System.out.println("success at i = " + i);
				return ts;
			}
			i++;
		}
	}
	
	private void init() {
		File file = new File(Constants.FILE_PATH);
		// TODO, we probably need to lock the file
		boolean firstTimeRun = !file.exists();
		try {
			map = ChronicleMapBuilder
			    .of(Long.class, Long.class)
			    .name(Constants.MAP_NAME)
			    .entries(2)
			    .createPersistedTo(file);
			if (firstTimeRun) {
				map.put(Constants.LOCK_KEY, Constants.LOCK_VALUE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
