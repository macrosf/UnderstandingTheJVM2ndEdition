package understanding.the.jvm.second.edition.chapter02.codelist_2_5;

/**
*VM Args：-Xss2M（这时候不妨设置大些）
*@author zzm
*/
public class JavaVMStackOOM {
	private void dontStop(){
		while(true){	
		}
	}
	
	//public 
}
