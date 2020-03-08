package com.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

//--priorityBlockQueue()
//--no null object can be inserted
//--It also implements BlockingQueue interface
//--it uses the same ordering rules as the PriorityQuerue class -> have to implement the Comparable interface the comparable interface will determine what will be the order in the queue
//--priority can be the same compare()



class Firstworker_p implements Runnable{
	private BlockingQueue<Person_c> blockingQueue;
	
	
	public Firstworker_p(BlockingQueue<Person_c> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() {
		try {
			blockingQueue.put(new Person_c(12,"sanjeet"));
			blockingQueue.put(new Person_c(30,"pal"));
			blockingQueue.put(new Person_c(20,"payal"));
			Thread.sleep(1000);
			blockingQueue.put(new Person_c(11,"rahul"));
			blockingQueue.put(new Person_c(05,"phulo"));
			Thread.sleep(2000);
			blockingQueue.put(new Person_c(52,"saurab"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

class Secondworker_p implements Runnable{
	private BlockingQueue<Person_c> blockingQueue;
	
	
	public Secondworker_p(BlockingQueue<Person_c> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

class Person_c implements  Comparable<Person_c>{
	private int age;
	private String name;
	public Person_c(int age,String name) {
		this.age=age;
		this.name=name;
	}
	@Override
	public int compareTo(Person_c otherPerson_c) {
		return name.compareTo(otherPerson_c.getName());
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name+age;
	}
}
public class PriorityblockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Person_c> queue=new PriorityBlockingQueue<>();
		new Thread(new Firstworker_p(queue)).start();
		new Thread(new Secondworker_p(queue)).start();
	}
}
