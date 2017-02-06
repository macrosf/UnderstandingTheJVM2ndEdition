package understanding.the.jvm.second.edition.chapter04.codelist4_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadMonitorTest {
	
	//线程死循环演示
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while (true) {;}
			}
		}, "testBusyThread");
		thread.start();
	}
	
	//线程锁等待演示
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				synchronized(lock){
					try{
						lock.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}, "testLockThread");
		thread.start();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("press enter to start busy thread...:");
		br.readLine();
		createBusyThread();
		
		System.out.println("press enter to start lock thread...");
		br.readLine();
		createLockThread(new Object());
	}
}
