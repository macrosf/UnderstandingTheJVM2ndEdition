package understanding.the.jvm.second.edition.chapter10.codelist10_9;

public class ConditionalCompilation {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		if(true){
			System.out.println("block 1");
		}else {
			System.out.println("block 2");
		}
		
		while(true){
			System.out.println("");
		}
	}
}
