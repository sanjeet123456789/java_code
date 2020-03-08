package com.Concurrent;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorker_h implements Runnable{
	private ConcurrentMap<String, Integer> map;
	public FirstWorker_h(ConcurrentMap<String,Integer> map) {
		this.map=map;
	}
	@Override
	public void run() {
		try {
			map.put("B", 1);
			map.put("H", 2);
			Thread.sleep(1000);
			map.put("F", 3);
			Thread.sleep(1000);
			map.put("A", 4);
			map.put("E", 5);
			Thread.sleep(1000);
			map.put("R", 6);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class SeocndWorker_h implements Runnable{
	private ConcurrentMap<String, Integer> map;
	public SeocndWorker_h(ConcurrentMap<String,Integer> map) {
		this.map=map;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(map.get("B"));
			Thread.sleep(1000);
			System.out.println(map.get("E"));
			System.out.println(map.get("F"));
			System.out.println(map.get("A"));
			System.out.println(map.get("H"));
			Thread.sleep(1000);
			System.out.println(map.get("R"));
			
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class Concurrent_Hashmap {
	public static void main(String[] args) {
		ConcurrentMap<String,Integer> map=new ConcurrentHashMap<>();
		
		
		new Thread(new FirstWorker_h(map)).start();
		new Thread(new SeocndWorker_h(map)).start();
		
	
	}
}
