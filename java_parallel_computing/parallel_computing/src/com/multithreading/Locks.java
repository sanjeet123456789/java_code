package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//reentrancelock (implementation of lock abstract class)
//fairnessParameter means longest waiting thread will get the change to processes
//if fairnessPrameter is false there is no access order
//new ReentrantLock(boolean fairness)
public class Locks {
	private static int counter =0;
	private static Lock lock=new ReentrantLock();
	public static void increment() {
		lock.lock();
		//cover for loop in try catch id exception occur the lock object will in deadlock situation
		//lock.unlock() will not be executed and we cannot use that object again
		
		try {
		for(int i=0;i<100000;i++)
			counter++;
		}finally {
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
//		System.out.println("hello");
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				increment();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				increment();
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}
}
