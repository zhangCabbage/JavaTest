package zhang.algorithm.JavaTest.JVM.OutOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 * <p>
 * JVM args:
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 限制方法区的大小
 * <p>
 * print:
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
 * java.lang.OutOfMemoryError: Java heap space
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        constantPoolOOMTest();
//        stringInternTest();
    }

    private static void constantPoolOOMTest() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }

    /**
     * 字符串常量池的实现问题!!
     * <p>
     * print:
     * true | true | false
     * why?
     * intern的作用:
     * 如果str已经包含在常量池中, 那么返回常量池这个字符串对应的String对象
     * 否则, 将次字符串ia添加到常量池中
     */
    private static void stringInternTest() {
        String str1 = new StringBuffer("Hello ").append("World!").toString();
        System.out.println(str1.intern() == str1);
        //Hello World! 字符串第一次出现在, 添加到常量池, 返回true

        String str2 = new StringBuffer("计算机").append("科学").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuffer("Hello ").append("World!").toString();
        //Hello World! 非第一次出现, str3.intern()获取的是原来常量池中的string对象, 跟之后在堆中新建的string不同
        //故返回false
        System.out.println(str3.intern() == str3);
    }
}
