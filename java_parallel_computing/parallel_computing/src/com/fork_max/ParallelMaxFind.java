package com.fork_max;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFind extends RecursiveTask<Integer>{
	private int[] nums;
	private int lowindex;
	private int highindex;
	public  ParallelMaxFind(int[] nums,int lowindex,int highIndex){
		this.nums=nums;
		this.lowindex=lowindex;
		this.highindex=highIndex;
	} {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Integer compute() {
		if(highindex-lowindex< Fork_main.THRESHOLD) {
			return sequentialFind();
		}else {
			int middleIndex=(lowindex+highindex)/2;
			ParallelMaxFind task1=new ParallelMaxFind(nums, lowindex, middleIndex);
			ParallelMaxFind task2=new ParallelMaxFind(nums, middleIndex+1, highindex);
			invokeAll(task1,task2);
			//invoke to execute task1 and task2 fork method 
			return Math.max(task1.join(), task2.join());
		}
	}

	private Integer sequentialFind() {
		int max=nums[lowindex];
		for(int i=lowindex;i<highindex;i++) {
			if(nums[i]>max) {
				max=nums[i];
			}
		}
		return max;
	}

}
