package com.Concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//--Latch--multiple thread can wait for each other
//--A CyclicBarrier is used in situation where you want to create a group of task
//--to perform work in parallel +wait until they are all finished before  moving to next step
//			-->something like join()
//			-->Something like CountDowmLatch()
//		
//--			countDownLatch:one-shot event
//			cyclicBarrier :it can be reused over and over again
//				+cyclicBarrier has a barrier action a runnable ,that will run automatically when the count reaches 0;
//			
//--new CyclicBarrier(N) N thread will wait for each other
//-- we can not reuse latches but we can reuse cyclicBarrier -->reset();

class People6 implements Runnable{
	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;
	
	public People6(int id,CyclicBarrier cyclicBarrier) {
		this.id=id;
		this.cyclicBarrier=cyclicBarrier;
		this.random=new Random();
	}

	@Override
	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("Thread id:"+id+" work");
		try {
			Thread.sleep(random.nextInt(7000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread id :"+id+"finish job");
		try {
			cyclicBarrier.await();
			System.out.println("after await execution");//executed by five thraed
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString() {
		return "id"+this.id;
	}
}


public class Cyclic_barrier {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		CyclicBarrier barrier=new CyclicBarrier(5,new Runnable() {
			@Override
			public void run() {
				System.out.println("All the task are finished..");
			}
			
		});
		for(int i=0;i<5;i++) {
			executorService.execute(new People6(i+1, barrier));
			
		}
		executorService.shutdown();
		
	}
}
