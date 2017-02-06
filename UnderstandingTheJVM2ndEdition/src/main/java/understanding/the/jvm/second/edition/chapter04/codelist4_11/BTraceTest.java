package understanding.the.jvm.second.edition.chapter04.codelist4_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {
	public static int add(int a, int b){
		return a+b;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<10; i++){
			System.out.println("press enter to print result of a+b:...");
			reader.readLine();
			int a = (int) Math.round(Math.random()*1000);
			int b = (int) Math.round(Math.random()*1000);
			System.out.println(add(a,b));
		}
	}
}

//程序运行后，在VisualVM中打开该程序的监视，在BTrace页签填充TracingScript的内容，输入的调试代码如代码清单4-12所示。

//代码清单4-12　BTrace调试代码
///* BTrace Script Template */
//import com.sun.btrace.annotations.*;
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//	/* put your code here */
//
//	@OnMethod(
//		clazz="understanding.the.jvm.second.edition.chapter04.codelist4_11.BTraceTest",
//		method="add",
//		location=@Location(Kind.RETURN)
//	)
//    public static void func(@Self understanding.the.jvm.second.edition.chapter04.codelist4_11.BTraceTest instance,int a, int b, @Return int result){
//		println("调用堆栈：");
//		jstack();
//		println(strcat("方法参数A：", str(a)));
//		println(strcat("方法参数B：", str(b)));
//		println(strcat("方法结果：", str(result)));
//    }
//}
