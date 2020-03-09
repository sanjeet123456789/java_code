package com.library_simulation;

import java.util.Random;


public class Student implements Runnable{
	private int id;
	private Book[] books;
	public Student(int id,Book[] books) {
		this.id=id;
		this.books=books;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "student"+id;
	}


	public void run() {
		Random random=new Random();
		while(true) {
			int bookId=random.nextInt(Constants.NUMBER_OF_BOOKS);
			try {
				books[bookId].read(this);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
