package understanding.the.jvm.second.edition.chapter07.codelist7_2;

/**
*被动使用类字段演示一：
*通过子类引用父类的静态字段，不会导致子类初始化
**/
class SuperClass{
	static {
		System.out.println("SuperClass init!");
	}
	public static int value=123;
}

/**
*被动使用类字段演示二：
*通过数组定义来引用类，不会触发此类的初始化
**/
public class NotInitialization {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SuperClass[] sca = new SuperClass[10];
	}
}
