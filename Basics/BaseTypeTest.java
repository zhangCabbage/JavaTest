package zhang.algorithm.JavaTest.Basics;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/18
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public class BaseTypeTest {
    /**
     * 常见运算
     */
    public static void test1() {
        //0.4在计算机的二进制存储系统中无法精确表示
        //解决方法: 1)使用BigDecimal 2)先扩大成整数, 进行逻辑计算, 之后再缩小
        System.out.println(10.00 - 9.60); //0.40000000000000036

        System.out.println(Math.round(10.5)); //11
        System.out.println(Math.round(-10.5)); //-10

        Random random = new Random(1000);//不管运行多少次, 产生的随机数都是相同的
        for (int i = 0; i < 4; i++) {
            System.out.println("第" + i + "次: " + random.nextInt());
        }
    }

    /**
     * 字符串比较, 以及常用字符串方法
     */
    public static void test2() {
        System.out.println("Admin" == "Admin"); //true
        System.out.println("Admin" == "admin"); //false
        System.out.println("Admin".toLowerCase() == "admin"); //false
        //toLowerCase 最后返回 new String("");
    }

    /**
     * 运算符
     */
    public static void test3() {
        System.out.println("5  --> " + Integer.toBinaryString(5));
        System.out.println("-5 --> " + Integer.toBinaryString(-5));
        System.out.println("~5 --> " + Integer.toBinaryString(~5));
    }

    /**
     * try catch 测试, 如果try和finally中同时有return, 那finally中的return起作用
     *
     * @return
     */
    public static int test4() {
        //1): return 2
//        try {
//            return 1;
//        } finally {
//            return 2;
//        }

        int a = 0;
        try {
            a = 3;
            //2): return 3
//            return a;

            //会先把return的结果暂存在局部变量栈中, 之后再操作finally
            //3): return 6
            return a * 2;
        } finally {
            a = 2;
        }
    }

    public static void test5() {
        char c = '章';
        System.out.println("c --> " + c);
        int 张bian = 3;
        System.out.println("variable --> " + 张bian);
    }

    /**
     * 关于数字小数格式化
     */
    public static void test6() {
        DecimalFormat format1 = new DecimalFormat("###.000");
        DecimalFormat format2 = new DecimalFormat("000.000");
        DecimalFormat format3 = new DecimalFormat("000.000");
        format3.setRoundingMode(RoundingMode.CEILING);

        System.out.println("12.2325 format[###.000] default --> " + format1.format(12.2325));
        System.out.println("12.2325 format[000.000] default --> " + format2.format(12.2325));
        System.out.println("12.2325 format[000.000] Ceiling --> " + format3.format(12.2325));

//        result:
//        12.2325 format[###.000] default --> 12.232
//        12.2325 format[000.000] default --> 012.232
//        12.2325 format[000.000] floor --> 012.233
    }

    public static void test7() {
        char[] c = {'a', 'b'};
        System.out.println("ab".equals(Arrays.toString(c))); //false
    }

    //---------------------------------------------------------------------------------------
    //枚举类可以实现接口
    //---------------------------------------------------------------------------------------
    interface A {
    }

    enum B implements A {

    }
    //---------------------------------------------------------------------------------------

    /**
     * 测试hashmap
     * before map --> {null=1, 1=null}
     * after map --> {null=2, 1=null}
     * after map --> {null=2, 1=null, 2=null}
     */
    public static void test8() {
        System.out.println("test8");
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, 1);
        map.put(1, null);
        System.out.println("before map --> " + map);

        map.put(null, 2);
        System.out.println("after map --> " + map);

        map.put(2, null);
        System.out.println("after map --> " + map);
    }

    public static void test9() {
        List list = new ArrayList<>(10);
        list.add(12);
        System.out.println("list --> " + list);
        System.out.println("list --> " + list.size());
    }

    public static void main(String[] args) {
        test9();
    }
}
