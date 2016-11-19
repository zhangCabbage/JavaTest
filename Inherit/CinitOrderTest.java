package zhang.algorithm.JavaTest.Inherit;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/19
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public class CinitOrderTest {
    /**
     * first:
     * 1) 父类clinit
     * 2) 父类init
     * 3) 子类clinit
     * 4) 子类init
     * 
     * second:
     * abstract可以用在没有abstract方法的类声明中
     *
     * @param args
     */
    public static void main(String[] args) {
        Sub sub = new Sub();
        //a --> 12
        //b --> 34
    }
}

abstract class Base {
    public static int a = 12;

    static {
        System.out.println("a --> " + a);
    }
}

class Sub extends Base {
    public static int b = 34;

    static {
        System.out.println("b --> " + b);
    }
}
