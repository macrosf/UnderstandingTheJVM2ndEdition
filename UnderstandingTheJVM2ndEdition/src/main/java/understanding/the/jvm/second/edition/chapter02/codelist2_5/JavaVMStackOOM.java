package understanding.the.jvm.second.edition.chapter02.codelist2_5;

/**
*VM Args：-Xss2M（这时候不妨设置大些）
*@author zzm
*/
public class JavaVMStackOOM {
	private void dontStop(){
		while(true){	
		}
	}
	
	public void stackLeakByThread(){
		while (true){
			Thread thread = new Thread(new Runnable(){
				public void run(){
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args){
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
