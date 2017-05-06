package zhang.algorithm.JavaTest.Guava;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/9
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    private int outterNum = 12;

    static void f(float a, Character... args) {
        System.out.println("one");
    }

    static void f(Character... args) {
        System.out.println("two");
    }

    static void customPrint() {
        System.out.println("A");
    }

    static int finallyReturn() {
        //返回12, 输出13
        int i = 12;
        try {
            return i++;
        } finally {
            System.out.println("i --> " + i);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        Optional<Integer> num = Optional.fromNullable(null);
//        System.out.println(num.isPresent());
//        System.out.println(num.or(12));
//        System.out.println(Preconditions.checkNotNull(34));
//
//
//        System.out.println(MoreObjects.toStringHelper("MyTestClass").addValue(true).add("second", 12).toString());
//        ComparisonChain.start().compare(12, 12);
//
//        List<Integer> one = new ArrayList<Integer>();
//        one.add(3);
//        one.add(1);
//        one.add(2);
//        System.out.println("one --> " + one);
//
//        List<Integer> two = new ArrayList<>(one);
//        one.add(4);
//        System.out.println("one --> " + one);
//        System.out.println("two --> " + two);
//
//        System.out.println("ordered one --> " + Ordering.natural().sortedCopy(one));
//        System.out.println("one --> " + one);
//
//        ImmutableSet<Integer> numSets = ImmutableSet.of(1, 2, 3);
//        ImmutableList<Integer> a = numSets.asList();
//        ImmutableList<Integer> b = numSets.asList();
//        System.out.println(a == b);
//
//        System.getProperties().list(System.out);


        short s = -1;
        println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(s);

        short a = 1, b = 2;
        int i = 0;
        for (; i < 10; i++) {
            if (i == 4) break;
        }
        System.out.println("i --> " + i);

        f(1, 'a');
        Test2.f();
        new Test2().g();

        Test4 test4 = new Test4() {
            public void g() {
                System.out.println("new Test4 -> g()");
            }
        };
        test4.g();

        System.out.println(new Test2().getClass());  //class zhang.algorithm.JavaTest.Guava.Test2
        System.out.println(new Test2().getClass().getName());  //zhang.algorithm.JavaTest.Guava.Test2
        System.out.println(new Test2().getClass().getSimpleName());  //Test2

        System.out.println(finallyReturn());

    }

    static class Test1 {
        static void f() {
            System.out.println("f()");
        }

        final void g() {
            System.out.println("g()");
        }
    }

    static class Test2 extends Test1 {
        //只要不是private方法都可以被继承, 包括静态和final方法
    }

    interface Test3 {
        Object f();
    }

    static class Test4 {
        public Test1 f() {
            return null;
        }

        public void g() {
            System.out.println("Test4 -> g()");
        }
    }

    static class Test5 extends Test4 implements Test3 {

    }
}


