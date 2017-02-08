package understanding.the.jvm.second.edition.chapter07.codelist7_6;

public class DeadLoop {
	static class DeadLoopClass{
		static{ 
			if (true){	//*如果不加上这个if语句，编译器将提示"Initializer does not complete normally"并拒绝编译*/
				System.out.println(Thread.currentThread()+": init DeadLoopClass");
				while(true){}
			}	//end of if(true) 
		} //end of static
	}
	
	public static void main(String[] args){
		Runnable script = new Runnable(){
			public void run() {
				System.out.println(Thread.currentThread()+": start...");
				@SuppressWarnings("unused")
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread()+": run over.");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
