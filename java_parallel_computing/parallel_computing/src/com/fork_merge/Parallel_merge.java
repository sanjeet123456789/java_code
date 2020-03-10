package com.fork_merge;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class Parallel_merge extends RecursiveAction{
	private int[] nums;
	public Parallel_merge(int[] nums) {
		// TODO Auto-generated constructor stub
		this.nums=nums;
	}
	
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(nums.length<=10) {
			mergeSort(nums);
			return;
		}else {
			int middle=nums.length/2;
			int[] left=Arrays.copyOfRange(nums,0,middle);
			int[] right=Arrays.copyOfRange(nums,middle,nums.length);
			//use middle in right not middle+1
			
			Parallel_merge lefttask=new Parallel_merge(left);
			Parallel_merge righttask=new Parallel_merge(right);
			invokeAll(lefttask,righttask);
			merge(left,right,nums);
			
		}
		
	}
	public void mergeSort(int[] nums) {

		if (nums.length <= 1)
			return;

		int mid = nums.length / 2;

		int[] left = Arrays.copyOfRange(nums, 0, mid);
		int[] right = Arrays.copyOfRange(nums, mid, nums.length);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, nums);
	}

	private void merge(int[] left, int[] right, int[] originalArray) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				originalArray[k++] = left[i++];
			else
				originalArray[k++] = right[j++];
		}

		while (i < left.length)
			originalArray[k++] = left[i++];

		while (j < right.length)
			originalArray[k++] = right[j++];
	}

}

	

