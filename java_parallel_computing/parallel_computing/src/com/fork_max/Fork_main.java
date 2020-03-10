package com.fork_max;

import java.util.Random;

public class Fork_main {
	public static int THRESHOLD = 0;

	public static void main(String[] args) {
		int[] nums=intitalize();
		THRESHOLD=nums.length/Runtime.getRuntime().availableProcessors();
		long start=System.currentTimeMillis();
		
		
		ParallelMaxFind para=new ParallelMaxFind(nums,0, nums.length);
		int max=para.compute();
		System.out.println("max value: "+max);
		System.out.println("time taken: "+(System.currentTimeMillis()-start));
	}

	private static int[] intitalize() {
		Random random=new Random();
		int[] nums=new int[100000];
		for(int i=0;i<100000;i++) {
			nums[i]=random.nextInt(100);
//			System.out.println(nums[i]);
		}
		return nums;
	}
}
