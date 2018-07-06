/*
* @Author: pankajgoyal7
* @Date:   2018-04-28 22:25:12
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-05-01 01:05:10
*/


class MultiThreadExtend {

	public static void main(String args[]) throws InterruptedException{  
		
		Thread1 t1 = new Thread1();  
		t1.start();
		t1.join();
		System.out.println("Main Thread.....");
	}  
}   
class Thread1 extends Thread{
	public void run(){  
		for(int i=0;i<5;i++){
			System.out.println("thread 1... "+i);
		}
	}  
}

