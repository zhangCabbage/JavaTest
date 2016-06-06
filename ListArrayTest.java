package zhang.algorithm.JavaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/5.
 */
public class ListArrayTest {
    public static void main(String[] args) {
        List<Integer> one = new ArrayList<Integer>();
        one.add(0);
        one.add(1);
        one.add(2);
        one.add(3);
        System.out.println(one);

        List<Integer> two = new ArrayList<Integer>();
        two.add(4);
        two.add(5);
        two.add(6);
        two.add(7);
        System.out.println(two);

        one.addAll(two);
        System.out.println(one);

        List<Integer> three = new ArrayList<Integer>();
        two.addAll(three);
        System.out.println(two);
    }
}
