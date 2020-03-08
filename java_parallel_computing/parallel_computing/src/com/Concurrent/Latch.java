package com.Concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//--this is used to synchronized one or more tasks by forcing them to wait for the completion of a set of operations
//being performed by other tasks
//
//--you  give an initial count to a CountDownlatch object, and any task that calls awaits();
//on that object will block until the count reaches zero
//-- Other tasks may call countDown on the object to reduce the count presumably  when a task finishes its jobs
//--countDownLatch count cannot be reset
//	if you need version that resets the count you can use a CyclicBarrier instead
//--the task that call countDOwn() are not blocked when they make that call Only tha call to wait() is blocked untill the notify is done
//
//--A typical use is to divide a problem into n independently solvable task and create a countdowmlatch with of N when each task is finished it calls countDown() on the latch .Tasks waiting for the problem to be solved call await();
//		on the latch to hold themselves back until it is completed. 
//--exmple :tigger treding after 10000 users watch the movie for 2 times


class People5 implements Runnable{
	private int id;
	private CountDownLatch countDownLatch;
	//constructor
	public People5(int id,CountDownLatch countDowmLatch) {
		this.id=id;
		this.countDownLatch=countDowmLatch;
	}
	
	@Override
	public void run() {
		dowork();
		countDownLatch.countDown();
	}

	private void dowork() {
		System.out.println("Thread id:"+this.id+"people working");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Latch {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		CountDownLatch latch=new CountDownLatch(2);
		//we canot use latch we it reache to zero
		//instead use CyclicBarrier for reuse countdown on object create
		
		for(int i=0;i<5;i++) {
			executorService.execute(new People5(i+1, latch));
		}
		try {
			latch.await();//main thread are block until it call countDown 5 times
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All the prerequisites is done..");
	}
}
