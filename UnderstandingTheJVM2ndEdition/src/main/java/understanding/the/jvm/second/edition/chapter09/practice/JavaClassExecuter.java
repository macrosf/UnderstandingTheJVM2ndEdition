package understanding.the.jvm.second.edition.chapter09.practice;

import java.lang.reflect.Method;

/**
 * JavaClass执行工具
 *
 * @author zzm
 */
public class JavaClassExecuter {
	/**
	 * 执行外部传过来的代表一个Java类的byte数组＜br＞
	 * 将输入类的byte数组中代表java.lang.System的CONSTANT_Utf8_info常量修改为劫持后的HackSystem类
	 * 执行方法为该类的static main(String[]args)方法,输出结果为该类向System.out/err输出的信息
	 * 
	 * @param classByte代表一个Java类的byte数组
	 * @return执行结果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String execute(byte[] classByte) {
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classByte);
		byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System",
				"understanding/the/jvm/second/edition/chapter09/practice/HackSystem");//根据HackSystem的实际所在包修改
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(modiBytes);
		try {
			Method method = clazz.getMethod("main", new Class[] { String[].class });
			method.invoke(null, (Object) new String[] { null });
		} catch (Throwable e) {
			e.printStackTrace(HackSystem.out);
		}
		return HackSystem.getBufferString();
	}
}
