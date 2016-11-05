package zhang.algorithm.JavaTest.JVM.SyntaxSugar;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/5
 * Time: 下午6:58
 * To change this template use File | Settings | File Templates.
 */
public class BroadType {
    /**
     * 由于Java泛型为语法糖, 称为伪泛型, 编译后<String><Integer>的区别就会被擦除
     * 而Java函数的签名, 不会看返回值, 只看参数个数, 类型, 顺序; 所以重载失败!!
     *
     * @param list
     * @return
     */
    public static String println(ArrayList<String> list) {
        System.out.println("String");
        return "";
    }

//    public static int println(ArrayList<Integer> list) {
//        System.out.println("Integer");
//        return 12;
//    }

    public static void main(String[] args) {
        println(new ArrayList<String>());
//        println(new ArrayList<Integer>());
    }
}
