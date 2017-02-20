package understanding.the.jvm.second.edition.chapter08.codelist8_10;

/**
 * 单分派、多分派演示
 *
 */
public class Dispatch {
	static class QQ{}
	static class _360{}
	public static class Father{
		public void hardChoise(QQ arg){
			System.out.println("father choose qq");
		}
		public void hardChoise(_360 arg){
			System.out.println("father choose 360");
		}
	}
	
	public static class Son extends Father{
		public void hardChoise(QQ arg){
			System.out.println("son choose qq");
		}
		public void hardChoise(_360 arg){
			System.out.print("son choose 360");
		}
	}
	
	public static void main(String[] args){
		Father father = new Father();
		Father son = new Son();
		father.hardChoise(new _360());
		son.hardChoise(new QQ());
		//int[][] a = new int[1][0];
		//System.out.println(a[0]);
	}
}
