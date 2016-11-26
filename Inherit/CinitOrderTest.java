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
     * First:
     * 1) 父类clinit
     * 2) 父类init
     * 3) 子类clinit
     * 4) 子类init
     * <p>
     * Second:
     * abstract可以用在没有abstract方法的类声明中
     *
     * Third
     * 一般类中[所有的构造函数]都会默认[调用父类的无参构造函数]
     *
     * @param args
     */
    public static void main(String[] args) {
        Sub sub = new Sub(1);
        //a --> 12
        //b --> 34
        //父类, 无参构造
        //子类, 有参构造1
    }
}

abstract class Base {
    public static int a = 12;

    static {
        System.out.println("a --> " + a);
    }

    public Base() {
        System.out.println("父类, 无参构造");
    }

    public Base(int i) {
        System.out.println("父类, 有参构造" + i);
    }
}

class Sub extends Base {
    public static int b = 34;

    static {
        System.out.println("b --> " + b);
    }

    public Sub() {
        System.out.println("子类, 无参构造");
    }

    public Sub(int i) {
        System.out.println("子类, 有参构造" + i);
    }
}
