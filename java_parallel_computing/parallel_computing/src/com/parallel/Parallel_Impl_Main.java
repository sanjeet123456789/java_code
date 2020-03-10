package com.parallel;

import java.util.Random;

public class Parallel_Impl_Main {
	public static Random random=new Random();
	public static void main(String[] args) {
		int numofThread=Runtime.getRuntime().availableProcessors();
		int[] nums= {4,2,6,5,44,78,-4,0,1};
//		Merging mergesort=new Merging(nums);
//		mergesort.parallelMergeSort(0,nums.length-1, numofThread);
//		
//		mergesort.showResult();
		System.out.println("number of therad"+numofThread);
		int[] numbers=createRandomResult();
		Merging mergesort =new Merging(numbers);
		long startTime=System.currentTimeMillis();
		mergesort.parallelMergeSort(0, numbers.length-1, numofThread);
		long endTime=System.currentTimeMillis();
		
		System.out.println("time taken in parallel"+(endTime-startTime));
		
		startTime =System.currentTimeMillis();
		mergesort.mergin(0, numbers.length-1);
		endTime=System.currentTimeMillis();
		System.out.println("time taken:"+(endTime-startTime));
		
	}
	public static int[] createRandomResult() {
		int[] a=new int[40000000];
		for(int i=0;i<40000000;i++) {
			a[i]=random.nextInt(1000000);
		}
		return a;
	}
}
 