package com.fork_join;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {
	private int simulatedWork;
	public  SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork=simulatedWork;
	}
	@Override
	protected void compute() {
		if(simulatedWork>100) {
			System.out.println("Parallel execution split task "+simulatedWork);
			SimpleRecursiveAction simpleRecursiveAction=new SimpleRecursiveAction(simulatedWork/2);
			SimpleRecursiveAction simpleRecursiveAction2=new SimpleRecursiveAction(simulatedWork/2);
			
			simpleRecursiveAction.fork();
			simpleRecursiveAction2.fork();
			
		}else {
			System.out.println("no need for parallel "+simulatedWork);
		}
	}
	
}
