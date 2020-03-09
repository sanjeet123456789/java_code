package com.library_simulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {
	public static void main(String[] args) {
		Student[] students=null;
		Book[] books=null;
		ExecutorService executorService=Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENT);
		try {
			
			books=new Book[Constants.NUMBER_OF_BOOKS];
			students=new Student[Constants.NUMBER_OF_STUDENT];
			for(int i=0;i<Constants.NUMBER_OF_BOOKS;i++) {
				books[i]=new Book(i);
			}
			for(int i=0;i<Constants.NUMBER_OF_STUDENT;i++) {
				students[i]=new Student(i, books);
				executorService.execute(students[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
			executorService.shutdown();
		}finally {
			executorService.shutdown();
		}
	}
}
