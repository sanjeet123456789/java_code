package com.multithreading;


//Every read of a volatile will be read from the RAM so from the main memory
//not from cache usually variable are cached for performance reason
//Caches are faster donot use volatile keyword if not necessary
//cache prevent instruction reordering which is a performance boost technique

class Worker implements Runnable{
	 private volatile boolean isTerminated=false;
	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("this is from worker");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
}

public class Volatile {
	public static void main(String[] args) {
		Worker worker=new Worker();
		Thread t=new Thread(worker);
		Thread t2=new Thread(worker);
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worker.setTerminated(true);
//		t2.start();
		System.out.println("finished");
	}
}
