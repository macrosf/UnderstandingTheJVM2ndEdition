package understanding.the.jvm.second.edition.chapter10.codelist10_8;

public class TrapOfAutoBoxing {
	public static void main(String[] args){
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=321;
		Integer f=321;
		Long g=3L;
		System.out.println(c==d);		//true	
		System.out.println(c.equals(d));//true
		System.out.println(e==f);		//false
		System.out.println(e.equals(f));//true
		System.out.println(c==(a+b));	//true
		System.out.println(c.equals(a+b));//true
		System.out.println(g==(a+b));	  //true
		System.out.println(g.equals(a+b));//false
		System.out.println(g.equals(c));  //false
		
//		Integer e1=1610;
//		Integer e2=1600;
//		Integer e3=3210;
//		System.out.println(e3==(e1+e2));
//		System.out.println(e3.equals(e1+e2));
	}
}
