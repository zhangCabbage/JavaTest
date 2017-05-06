package zhang.algorithm.JavaTest.ThinkingJava;


import java.lang.ref.SoftReference;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/23
 * Time: 下午9:05
 * To change this template use File | Settings | File Templates.
 */
public class Chapter13_String {

    public static void main(String[] args) {
        Chapter13_String test = new Chapter13_String();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("before rotate --> " + list);
        Collections.rotate(list, 3);
        System.out.println("after rotate --> " + list);


        SoftReference ref = new SoftReference<String>("123");
        System.out.println(ref);
        System.gc();
        System.out.println(ref.get());

    }

}