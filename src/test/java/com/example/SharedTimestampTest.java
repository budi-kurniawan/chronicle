package com.example;

import org.junit.jupiter.api.Test;

public class SharedTimestampTest {
	
	@Test
	public void testSharedTimestamp() {
		Runnable task = () -> {
			SharedTimestamp st = new SharedTimestamp();
			for (int i = 0; i < 40; i++) {
				System.out.println(st.timestamp());
//				try {
//					Thread.sleep(200);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		};

		int NUM_THREADS = 10;
		Thread[] threads = new Thread[NUM_THREADS];
		
		for (int i = 0; i < NUM_THREADS; i++) {
			threads[i] = new Thread(task);
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			threads[i].start();
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SharedTimestampTest test = new SharedTimestampTest();
		test.testSharedTimestamp();;
	}
}
