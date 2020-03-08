package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//semophores maintain a set of permit
//acquire() if a permit is available then takes
//release() adds  a permit
//
//semaphores just keeps a count of the number of resource available
//new Semaphore(int permit,boolean fair)
//
//

enum Uploader{
	INSTANCE;
		private Semaphore semaphore=new Semaphore(5,true);
		public void uploadData() {
			try {
				semaphore.acquire();
				upload();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaphore.release();
			}
		}
		private void upload() {
			System.out.println("upload data to internet");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
public class Semaphores {
	public static void main(String[] args) {
		
		ExecutorService executerService=Executors.newCachedThreadPool();
		for(int i=0;i<20;i++) {
			executerService.execute(new Runnable() {
				public void run() {
					Uploader.INSTANCE.uploadData();
				}
			});
		}
	}
}
