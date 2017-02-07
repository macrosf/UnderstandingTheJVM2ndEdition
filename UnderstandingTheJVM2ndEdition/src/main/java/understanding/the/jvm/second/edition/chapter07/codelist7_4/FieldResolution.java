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
	
	//测试接口的成员变量都是静态的
	class Sub0 implements Interface0{}
	static class SSub0 implements Interface0{}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		System.out.println(Sub.A);
		
		//内部非静态类需要用new 外部类名().new 内部类名()来声明
		Sub0 sub0= new FieldResolution().new Sub0();
		System.out.print(sub0.A);//这种访问方式会有一个Warning
		//sub0.A = 9;//编译错误：The final field FieldResolution.Interface0.A cannot be assigned
		//Sub0.A = 9;//和上面一样的编译错误
		//SSub0.A = 9;//内部静态类也和上面一样的编译错误
		System.out.println(Sub0.A);//证明了接口内声明的变量是静态的
	}
}
