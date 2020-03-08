package com.multithreading;

import java.util.ArrayList;
import java.util.List;

class Processor2{
	private List<Integer> list=new ArrayList<>();
	private final int LIMIT=5;
	private final int BOTTOM=0;
	private final Object lock=new Object();
	private int value=0;
	public void produce() throws InterruptedException {
		synchronized(lock) {
			while(true) {
				if(list.size()==LIMIT) {
					System.out.println("waiting for removing item from the list");
					lock.wait();
				}else {
					System.out.println("Adding item to list"+value);
					list.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
	public void consume() throws InterruptedException {
		synchronized(lock) {
			while(true) {
				if(list.size()==BOTTOM) {
					System.out.println("witing item to brinserted");
					lock.wait();
				}else {
					System.out.println("consuming item from the list"+list.remove(--value));
					
					
					lock.notify();
				}
				Thread.sleep(500);//for good 
			}
		}
	}
}


public class Producer_and_consumer {
	public static void main(String[] args) {
		
		Processor2 processor2=new Processor2();
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor2.produce();
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
					processor2.consume();
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
