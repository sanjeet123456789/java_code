package com.fork_join;

import java.util.concurrent.ForkJoinPool;

//fork-join framework is a concreate implementation for parallel excution
//task is a light weight thread
//RecursiveTask<>->it will return a T type

//RecursiveAction it is a task without any return value
//ForkJoinPool->it is thread pool for executing fork-join tasks
//so ForkPool create a fic numbers of thread equal to  the number of cpu cores
//These Thread are executing the task but if a thread has no task:it can steal a task from more busy threads
//tasks are distributed to all threads in the thread pool
//fork split the given task into smaller subtasks that can be executed  in a parallel manner
//fork() asynchronously execute the given task in the pool
// 	we can call this on RecursiveAction or RecursiveTask<T>
//join() return the result of the computation when it is done
//		invoke() execute the given task* return its result uon completion

public class Fork_main {
	public static void main(String[] args) {
		// for simple ResursiveAction
		/*
		ForkJoinPool pool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction simpleRecursiveAction=new SimpleRecursiveAction(2000);
		pool.invoke(simpleRecursiveAction);
		*/
		
		//for simpleRecursiveTask
		ForkJoinPool pool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		SimpleRecursiveTask task=new SimpleRecursiveTask(2000);
		System.out.println(pool.invoke(task));
		
		
	}
}
