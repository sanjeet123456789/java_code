package com.dining_philosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private int id;
	private Lock lock;
	public Chopstick(int id) {
		this.id=id;
		this.lock=new ReentrantLock();
	}
	
	public boolean pickUp(Philosopher philospher,State state) throws InterruptedException{
		if(lock.tryLock(10,TimeUnit.MILLISECONDS)) {
			System.out.println(philospher+"picked up"+state.toString()+" "+this);
			return true;
		}
		return false;
	}
	public void putdowm(Philosopher philospher,State state) {
		lock.unlock();
		System.out.println(philospher+"put dowm"+this);
	}
	
	@Override
	public String toString() {	
		return "Chopstick"+id;
	}
} 
