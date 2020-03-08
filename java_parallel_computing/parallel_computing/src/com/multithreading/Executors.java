package com.multithreading;

import java.util.concurrent.ExecutorService;

//1 . ExecutorService executorService =Executor.newCachedThreadPool();
//--return executorService that  can dynamically reuse thread
//--before executing it will first check whether there are any thread that finished the job reuse them
//--if no waiting thread it is going to create another one
//-- good for the processor effective solution
//2. ExecutorService executorService =Executor.newFixedThreadPool(N);
//--N is max number of thread to be created
//--if we start a job - It will first check if all thread are busy ,we have to wait for one to terminate
//3. ExecutorService executorService =Executor.newSingleThreadExecutor();
//-- it use single thread for the job
//--execute() runnable +callable
//--submit()--runnable

public class Executors {
	 public static void main(String[] args) {
		ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++) {
			executorService.execute(new Foobies());
		}
		
	}
}

class Foobies implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}