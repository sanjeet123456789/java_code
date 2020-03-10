package com.fork_merge;

import java.util.concurrent.ForkJoinPool;

public class Merge_main {
	public static void main(String[] args) {
		int[] nums= {47,545,45,4,24,5,415,4,54,45,15,1,5154,1};
		ForkJoinPool pool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		Parallel_merge p_merge=new Parallel_merge(nums);
		pool.invoke(p_merge);
		
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]+"-"+i);
	}

}
