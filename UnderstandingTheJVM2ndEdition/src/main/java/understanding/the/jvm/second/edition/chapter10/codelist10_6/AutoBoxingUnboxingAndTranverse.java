package understanding.the.jvm.second.edition.chapter10.codelist10_6;

import java.util.Arrays;
import java.util.List;

public class AutoBoxingUnboxingAndTranverse {

	public static void main(String[] args){
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		//int[] list = new int[]{1,2,3,4};
		
		int sum=0;
		for(int i:list){
			sum+=i;
		}
		System.out.println(sum);
	}
}
