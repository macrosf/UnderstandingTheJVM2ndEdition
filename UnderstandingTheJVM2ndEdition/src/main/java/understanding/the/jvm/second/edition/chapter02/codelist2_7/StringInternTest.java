package understanding.the.jvm.second.edition.chapter02.codelist2_7;

public class StringInternTest {
	public static void main(String[] args){
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);	//jdk1.6: false; //jdk1.8: true
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern()==str2);	//jdk1.6: false; //jdk1.8: false
	}
}
