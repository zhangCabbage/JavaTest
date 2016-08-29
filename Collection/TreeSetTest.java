package zhang.algorithm.JavaTest.Collection;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/29
 * Time: 下午9:23
 * To change this template use File | Settings | File Templates.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSetTest test = new TreeSetTest();
        TreeSet<Stu> set = new TreeSet();
        Stu stu1 = new Stu("zhang", 14);
        set.add(stu1);
        System.out.println(set);

        Stu stu2 = new Stu("zhang", 12);
        set.add(stu2);
        System.out.println(set);

        Stu stu3 = new Stu("zhang", 15);
        set.add(stu3);
        System.out.println(set);

        Stu stu4 = new Stu("zhang", 13);
        set.add(stu4);
        System.out.println(set);

        Stu stu5 = new Stu("jiahua", 12);
        System.out.println(set.add(stu5));
        System.out.println(set);

//        print as follow:
//        [(zhang, 14)]
//        [(zhang, 12), (zhang, 14)]
//        [(zhang, 12), (zhang, 14), (zhang, 15)]
//        [(zhang, 12), (zhang, 13), (zhang, 14), (zhang, 15)]
//        false
//        [(zhang, 12), (zhang, 13), (zhang, 14), (zhang, 15)]
    }
}

class Stu implements Comparable<Stu> {
    private String name;

    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Stu stu) {
        return this.age - stu.age;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }
}