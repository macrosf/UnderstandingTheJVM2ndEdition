package understanding.the.jvm.second.edition.chapter02.codelist2_6;

import java.util.ArrayList;
import java.util.List;

/**
*VM Args：-XX：PermSize=10M-XX：MaxPermSize=10M
*@author zzm
*/
public class RuntimeConstantPool {
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
