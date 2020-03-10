package com.parallel;

public class Merging {
	private int[] nums;
	private int[] tempArray;
	public Merging(int[] nums) {
		this.nums=nums;
		tempArray=new int[nums.length];
	}
	
	public void parallelMergeSort(int low,int high,int numofThread) {
		if(numofThread<=1) {
			mergin(low, high);
			return;
		}
		int middleIndex=(low+high)/2;
		Thread leftSorter=mergeSortParallel(low,middleIndex,numofThread);
		Thread rightSorter=mergeSortParallel(middleIndex+1,high,numofThread);
		leftSorter.start();
		rightSorter.start();
		try {
			leftSorter.join();
			rightSorter.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		merge(low, middleIndex, high);
		
	}
	private Thread mergeSortParallel(int low,int high,int numOfThreads) {
		
		return new Thread() {
			@Override
			public void run() {
				parallelMergeSort(low,high,numOfThreads/2);
			}
		};
	}
	public void mergin(int low,int high) {
		if(low>=high) {
			return;
		}
		int middle=(low+high)/2;
		mergin(low,middle);
		mergin(middle+1,high);
		merge(low,middle,high);
		
	}
	public void showResult() {
		for(int i=0;i<nums.length;++i) {
			System.out.println(nums[i]+" "+i);
		}
	}
	public void merge(int low,int middle,int high) {
		for(int i=low;i<=high;++i) {
			tempArray[i]=nums[i];
		}
		int i=low;
		int j=middle+1;
		int k=low;
		while((i<=middle)&&(j<=high)) {
			if(tempArray[i]<=tempArray[j]) {
				nums[k]=tempArray[i];
				i++;
			}else {
				nums[k]=tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			nums[k]=tempArray[i];
			k++;
			i++;
		}
		while(j<=high) {
			nums[k]=tempArray[j];
			k++;
			j++;
		}
		
	}
	public boolean isSorted() {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				return false;
			}
		} 
		return true;
	}
}
