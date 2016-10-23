package zhang.algorithm.JavaTest.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/17.
 */
public class CollectionTest {
    /**
     * construct list to test later
     *
     * @param num
     * @return
     */
    public static List<Integer> constructList(int num) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = num; i > 0; i--) {
            list.add(i);
        }
        return list;
    }

    /**
     * use to test the utils of collections
     */
    public static void collectionsTest() {
        List<Integer> list = CollectionTest.constructList(4);

        //1) add
        Collections.addAll(list, 5, 6);
        System.out.println(list);  //[4, 3, 2, 1, 5, 6]

        //2) traversal
        Iterator iter = list.iterator();
        iter.next();
        iter.remove();  //如果屏蔽上一句iter.next(),会报错
        System.out.println(list);
    }

    public static void main(String[] args) {
        CollectionTest.collectionsTest();
    }
}
