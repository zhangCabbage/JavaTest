package zhang.algorithm.JavaTest.Basics;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/13
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public class ClassloaderTest {
    static class A {
        {
            System.out.println("A");
        }

        static {
            System.out.println("static A");
        }
    }

    static class B extends A {
        {
            System.out.println("B");
        }

        static {
            System.out.println("static B");
        }
    }

    /**
     * static A
     * static B
     * A
     * B
     */
    public static void test1() {
        new B();
    }

    static class C {
        public static C c1 = new C();
        public static C c2 = new C();

        {
            System.out.println("C");
        }

        static {
            System.out.println("static C");
        }
    }

    /**
     * C
     * C
     * static C
     * C
     */
    public static void test2() {
        new C();
    }

    public static void main(String[] args) {
        test2();
    }
}
