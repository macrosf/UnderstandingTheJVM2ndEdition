package understanding.the.jvm.second.edition.chapter08.codelist8_2;

public class ReuseOfLocalVariableTableSlot {

	public static void main(String[] args){
		{
			@SuppressWarnings("unused")
			byte[] placeholder = new byte[1024*1024*64];
		}
		@SuppressWarnings("unused")
		int a=0;
		System.gc();
	}
}
