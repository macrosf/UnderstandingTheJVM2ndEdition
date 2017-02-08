package understanding.the.jvm.second.edition.chapter07.codelist7_5;

public class ReferenceFieldBeforeDefined {
	static {
		i = 0;	//给变量赋值可以正常编译通过
		//System.out.println(i);//这句编译器会提示"非法向前引用" --> Cannot reference a field before it is defined
	}
	static int i = 0;
}
