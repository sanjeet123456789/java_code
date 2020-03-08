package com.Concurrent;
//--with the help of Exchanger class two thread can exchange objects
//--exchange()-> exchanging objects is done via one of the two exchange() method
//--used in genetic neural network
import java.util.concurrent.*;

class FirstThread implements Runnable{
	private int counter;
	private Exchanger<Integer> exchanger;
	
	public FirstThread(Exchanger<Integer> exchanger) {
		this.exchanger=exchanger;
	}

	@Override
	public void run() {
		while(true) {
			counter=counter+1;
			System.out.println("First Thread"+counter);
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class SecondThread implements Runnable{
	private int counter;
	private Exchanger<Integer> exchanger;
	
	public SecondThread(Exchanger<Integer> exchanger) {
		this.exchanger=exchanger;
	}

	@Override
	public void run() {
		while(true) {
			counter=counter-1;
			System.out.println("second Thread"+counter);
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class Exchanger_h {
	public static void main(String[] args) {
		Exchanger<Integer> exchanger=new Exchanger<>();
		new Thread(new FirstThread(exchanger)).start();
		new Thread(new SecondThread(exchanger)).start();
	}
}
