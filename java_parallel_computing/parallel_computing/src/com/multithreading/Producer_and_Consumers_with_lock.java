package com.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//wait and notify is same as lock and signal
class People{
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	public void producer() throws InterruptedException{
		lock.lock();
		System.out.println("producer method");
		condition.await();
		System.out.println("producer again");
		lock.unlock();
	}
	
	public void consumer() throws InterruptedException{
		
		lock.lock();
		Thread.sleep(2000);
		System.out.println("consumer method");
		condition.signal();
		lock.unlock();
	}



}

public class Producer_and_Consumers_with_lock {
	public static void main(String[] args) {
		People p=new People();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					p.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					p.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		
	}
	
	
}
