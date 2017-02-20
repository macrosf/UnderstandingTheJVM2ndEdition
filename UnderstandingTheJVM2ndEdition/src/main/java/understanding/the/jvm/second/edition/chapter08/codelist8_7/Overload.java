package understanding.the.jvm.second.edition.chapter08.codelist8_7;

import java.io.Serializable;

/**
 * 代码清单8-7　重载方法匹配优先级
 * p281
 *
 */
public class Overload {

	public static void sayHello(Object arg){	//#6
		System.out.println("hello object");
	}
	public static void sayHello(int arg){	//#2
		System.out.println("hello int");
	}
	public static void sayHello(long arg){	//#3
		System.out.println("hello long");
	}
	public static void sayHello(char arg){	//#1
		System.out.println("hello char");
	}
	public static void sayHello(Character arg){	//#4
		System.out.println("hello Character");
	}
	public static void sayHello(char... arg){	//#7
		System.out.println("hello, char...");
	}
	public static void sayHello(Serializable arg){	//#5
		System.out.println("hello serializable");
	}
	
	public static void main(String[] args){
		sayHello('a');
	}
}
