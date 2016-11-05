package zhang.algorithm.JavaTest.JVM.ClassFile;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/31
 * Time: 下午5:20
 * To change this template use File | Settings | File Templates.
 */
public class StaticTest {

    static {
        i = 0; //可以赋值, 但是不能访问
    }

    public static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
