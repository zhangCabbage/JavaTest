package zhang.algorithm.JavaTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args){
//		以下三种循环都会编译出错
//		for(int i=0; i<10; i++)
//			Integer k = 1;
//		
//		if(true)
//			int test = 1;
//		
//		if(true)
//			int test;
//		
//		int i=0;
//		int j=0;
//		int a = ++i++;
		System.out.println("Hello World!");
		
		List list = new ArrayList<>();
		for(int i=0; i<10; i++){
			Object o = new Object();
			list.add(o);
			o = null;
		}
	}
}
