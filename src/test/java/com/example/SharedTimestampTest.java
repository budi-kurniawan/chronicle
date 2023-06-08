package com.example;

public class SharedTimestampTest {
	
	public static void main(String[] args) {
		Runnable task = () -> {
			SharedTimestamp st = new SharedTimestamp();
			for (int i = 0; i < 20; i++) {
				System.out.println(st.timestamp());
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
}
