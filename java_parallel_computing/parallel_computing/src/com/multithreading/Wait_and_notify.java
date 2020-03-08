package com.multithreading;

class Processor{
	public void produce() throws InterruptedException {
		synchronized(this) {
			System.out.println("we are in the producer method..");
			wait(20000);
			System.out.println("again in the producer");
		}
	}
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized(this){
			System.out.println("consumer method..");
			notify();
//			notifyAll();
			Thread.sleep(3000);//excute this code before notify
		}
	}
}


public class Wait_and_notify {
	public static void main(String[] args) {
		
		Processor processor=new Processor();
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.produce();
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
					processor.consume();
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
