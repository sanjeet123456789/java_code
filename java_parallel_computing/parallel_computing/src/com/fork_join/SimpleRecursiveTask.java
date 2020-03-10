package com.fork_join;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
	
	private int simulatedWork;
	
	public SimpleRecursiveTask(int simulateWork) {
		this.simulatedWork=simulateWork;
	}

	@Override
	protected Integer compute() {
		if(simulatedWork>100) {
			System.out.println("Parallel execution split task "+simulatedWork);
			SimpleRecursiveTask simpleRecursiveAction=new SimpleRecursiveTask(simulatedWork/2);
			SimpleRecursiveTask simpleRecursiveAction2=new SimpleRecursiveTask(simulatedWork/2);
			
			simpleRecursiveAction.fork();
			//fork will run the compute method again
			simpleRecursiveAction2.fork();
			int solution=0;
			solution=solution+simpleRecursiveAction.join();
			solution+=simpleRecursiveAction2.join();
			return solution;
			
		}else {
			System.out.println("no need for parallel "+simulatedWork);
			return 2*simulatedWork;
		}
		
	}
	
	
}	
