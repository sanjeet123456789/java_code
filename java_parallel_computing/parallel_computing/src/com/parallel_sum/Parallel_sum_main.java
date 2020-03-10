package com.parallel_sum;

import java.util.Random;

public class Parallel_sum_main {
	public static void main(String[] args) {
		Random random=new Random();
		int[] nums=new int[100000];
		for(int i=0;i<nums.length;i++) {
			nums[i]=random.nextInt(100);
					
		}
		
		
		int numofProcessors=Runtime.getRuntime().availableProcessors();
		long start=System.currentTimeMillis();
		System.out.println(numofProcessors);
		Parallel_summ parallelSum=new Parallel_summ(numofProcessors);
		System.out.println(parallelSum.sum(nums));
		System.out.println("time taken: "+(System.currentTimeMillis()-start));
	}
}
