package understanding.the.jvm.second.edition.chapter08.codelist8_15;

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
/**
 * 使用MethodHandle来实现子类中调用祖父类中的方法
 */
public class MethodHandleTest {

	class GrandFather{
		void thinking(){
			System.out.println("i am grandfather");
		}
	}
	class Father extends GrandFather{
		void thinking(){
			System.out.println("i am father");
		}
	}
	class Son extends Father{
		void thinking() {
			//super.super.thinking();	//not work
			MethodType mt = MethodType.methodType(void.class);
			try {
				MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
				mh.invoke(this);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		(new MethodHandleTest().new Son()).thinking();	//not run as expected!!
	}
}
