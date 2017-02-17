package understanding.the.jvm.second.edition.chapter08.codelist8_7;

public class Overload {

	public static void sayHello(Object arg){
		System.out.println("hello object");
	}
	public static void sayHello(int arg){
		System.out.println("hello int");
	}
	public static void sayHello(long arg){
		
	}
}
