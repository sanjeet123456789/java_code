package com.Concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//--Blockingqueue is an interface that represent a queue that is thread safe
//--Put item or task item from it at same time two different thread
//-- it can be implemented with consumer producer problem
//
//--put() putting items in queue
//--take() take item from the queue
//--remove()
//--get()
class firstPeople implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	//remember: BLockingQueue is synchronized
	
	public firstPeople(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() {
		int counter=0;
		while(true) {
			
			try {
				blockingQueue.put(counter++);
				
				System.out.println("putting item to the queue."+counter);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
class secondPeople implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	public secondPeople(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() {
		while(true) {
			
			try {
				int number=blockingQueue.take();
				System.out.println("taking item from the queue.."+number);
				
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
public class Blocking_Queue {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
		firstPeople first=new firstPeople(queue);
		secondPeople second=new secondPeople(queue);
		
		new Thread(first).start();
		new Thread(second).start();
		//create a thread using object name
	}
}
