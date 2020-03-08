package com.multithreading;


class Runner extends Thread {
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
class Runner2 extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("running2: " +i);
		}
	}
}

public class Multithreading_using_extends_thread {
	public static void main(String[] args)  {
	System.out.println(System.currentTimeMillis());

	Runner r=new Runner();
	Runner2 r2=new Runner2();
	r.start();
	r2.start();
		
	try {
		r.join();//main thread wait for r thread to finish the task
//		r2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(System.currentTimeMillis());
		
	}
}
