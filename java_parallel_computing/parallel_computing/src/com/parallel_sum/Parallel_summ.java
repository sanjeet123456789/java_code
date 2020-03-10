package com.parallel_sum;

public class Parallel_summ {
	private Parallel_worker[] sums;
	private int numOfThread;
	public Parallel_summ(int numOfThread) {
		this.numOfThread=numOfThread;
		this.sums=new Parallel_worker[numOfThread];
	}
	public int sum(int[] nums) {
		int steps= (int) Math.ceil(nums.length*1.0/numOfThread);
		for(int i=0;i<numOfThread;++i) {
			sums[i]=new Parallel_worker(nums, i*steps, (i+1)*steps);
			sums[i].start();
		}
		
			try {
				for(Parallel_worker worker:sums)
				worker.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int total=0;
			for(Parallel_worker worker:sums) {
				total+=worker.getPartialSum();
			}
			return total;
	}
}
