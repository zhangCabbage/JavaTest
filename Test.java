package zhang.algorithm.JavaTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
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
        for (int i = 0; i < 10; i++) {
            Object o = new Object();
            list.add(o);
            o = null;
        }

        System.out.println("------------" + (float) (3 / 2));

        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        one.add(two);
        System.out.println(one.toString());

        System.out.println("123" + 0);//1230
        System.out.println((int) 'A');//65
        System.out.println((int) 'Z');//90
        System.out.println((int) 'a');//97
        System.out.println((int) 'z');//122

        System.out.println("\\");

        char[] c = {'a', 'b', 'c'};
        System.out.println(String.valueOf(c, 1, 2));

        System.out.println(1 == 2);
        //boolean型变量的值为小写的true和false,python中为大写

        String name = "zhangjiahua";
        System.out.println(name.split("\\.").length);

        BigInteger a = null;
        BigInteger b = null;
        System.out.println(a == b);

        System.out.println((Integer.MIN_VALUE - 1) / -1);

        System.out.println("zhang_gao".indexOf("galo"));

        System.out.println("zhang.txt".endsWith(".txt"));
    }
}
