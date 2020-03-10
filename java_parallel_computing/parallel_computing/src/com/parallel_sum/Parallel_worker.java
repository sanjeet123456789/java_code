package com.parallel_sum;

import java.util.Random;

public class Parallel_worker extends Thread{
	Random random=new Random();
	private int[] nums;
	private int low;
	private int high;
	private int partialSum;
	
	public  Parallel_worker(int[] nums,int low,int high) {
		this.nums=nums;
		this.low=low;
		this.high=high;
		
	}
	public int getPartialSum() {
		return this.partialSum;
	}
	@Override
	public void run() {
		partialSum=0;
		for(int i=low;i<high;i++) {
			partialSum=partialSum+nums[i];
		}
	}
	
}
