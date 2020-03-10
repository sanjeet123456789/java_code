package com.parallel;

import java.util.Random;

public class MergeSort_ {
	public static void main(String[] args) {
		Random random=new Random();
		int[] nums=new int[30];
		
		
		for(int j=0;j<nums.length;j++)
			nums[j]=random.nextInt(1000);
		
		Merging merge=new Merging(nums);
		merge.mergin(0, nums.length-1);
		merge.showResult();
	}
}
