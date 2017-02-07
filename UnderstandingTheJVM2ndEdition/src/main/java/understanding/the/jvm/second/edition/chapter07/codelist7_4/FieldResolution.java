package understanding.the.jvm.second.edition.chapter07.codelist7_4;

public class FieldResolution {

	interface Interface0{
		int A=0;
	}
	
	interface Interface1 extends Interface0{
		int A=1;
	}
	
	interface Interface2 {
		int A=2;
	}
	
	static class Parent implements Interface1{
		public static int A=3;
	}
	
	static class Sub extends Parent implements Interface2{
		public static int A=4;	//注释掉这句后，main函数里面的print语句会编译出错
	}
	
	public static void main(String[] args){
		System.out.println(Sub.A);
	}
}
