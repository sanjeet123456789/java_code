package com.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//
//--This is an unbounded BlockingQueue of objects that implements the Delayed interface
//--DelayQueue keeps the elements internally untill a certain delay has expires
//--An object can onlt be taken from the queue when its delay  has expired
//--we cannot place null items in the queue The queue is sorted so that the object at the head a delay that has expired for the longest time
//--If no delay expired head will reaturn null
//--size() return the count of both expired and unexpired item

class DPeople implements Delayed{
	private long duration;
	private String message;
	public DPeople(long duration,String message) {
		this.duration=System.currentTimeMillis()+duration;
		this.message=message;
				
	}
	@Override
	public int compareTo(Delayed otherdelay) {
		if(this.duration<((DPeople) otherdelay).getDuration()) {
			return -1;
		}
		if(this.duration>((DPeople) otherdelay).getDuration()) {
			return 1;
		}
		return 0;
	}
	

	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}
	@Override
	public String toString() {
		return this.message;
	}
	
	
}

public class Delay_queue {
	public static void main(String[] args) {
		BlockingQueue<DPeople> queue=new DelayQueue<>();
		try {
			queue.put(new DPeople(1000,"first message "));
			queue.put(new DPeople(10000,"second message "));
			queue.put(new DPeople(4000,"third message "));
			queue.put(new DPeople(1000,"fourth message "));
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
