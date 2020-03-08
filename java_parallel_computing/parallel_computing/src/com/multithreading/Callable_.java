package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor3 implements Callable<String>{
	
	
	private int id;
	public  Processor3(int id) {
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String call() throws Exception {
	Thread.sleep(5000);
		return "id:"+id;
	}
	
}


public class Callable_ {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		List<Future<String>> list=new ArrayList<>();
	
		
		for(int i=0;i<5;i++) {
			Future<String> future=executorService.submit(new Processor3(i+1));
			list.add(future);
		
		}
		for(Future<String> future:list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}
}
