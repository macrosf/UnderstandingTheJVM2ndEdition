package understanding.the.jvm.second.edition.chapter07.codelist7_6;

public class ExecSequenceForMethodClinit {
	static class Parent {
		public static int A=1;
		static {
			A=2;
		}
	}
	
	static class Sub extends Parent{
		public static int B = A;
	}
	
	public static void main(String[] args){
		System.out.print(Sub.B);	//2
	}
}
