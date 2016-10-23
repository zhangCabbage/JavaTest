package zhang.algorithm.JavaTest.String;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/13
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = "ab";
        String c = "c";
        System.out.println(a == b + c);

        //java string format
        //[Reference]
        //http://blog.csdn.net/lonely_fireworks/article/details/7962171
        System.out.printf("%02d %n", 2);
        System.out.printf("%+d %n", 2);
        System.out.printf("%o %n", 16);
        System.out.printf("%#o %n", 16);
        System.out.printf("%x %n", 16);
        System.out.printf("%#x %n", 16);
    }
}
