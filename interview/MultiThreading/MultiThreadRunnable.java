/*
* @Author: pankajgoyal7
* @Date:   2018-04-28 22:28:34
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-04-28 22:29:44
*/
class MultiThreadRunnable implements Runnable{
	public void run(){
		System.out.println("thread running......");
	}

	public static void main(String[] args){
		MultiThreadRunnable m1 = new MultiThreadRunnable();
		Thread t1 = new Thread(m1);
		t1.start();
	}
}