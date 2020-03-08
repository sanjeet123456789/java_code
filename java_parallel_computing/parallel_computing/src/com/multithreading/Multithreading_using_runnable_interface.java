package com.multithreading;


class Runner3 implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("running1: " +i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Runner4 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("running2: " +i);
		}
	}
}

public class Multithreading_using_runnable_interface {
	public static void main(String[] args)  {
	System.out.println(System.currentTimeMillis());

	Thread t1=new Thread(new Runner3());
	Thread t2=new Thread(new Runner4());
	t1.start();
	t2.start();
		
	try {
		t1.join();//main thread wait for r thread to finish the task
//		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(System.currentTimeMillis());
		
	}
}
