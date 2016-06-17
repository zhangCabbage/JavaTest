package zhang.algorithm.JavaTest.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/17.
 */
public class CollectionTest {
    /**
     * construct list to test later
     * @param num
     * @return
     */
    public static List<Integer> constructList(int num){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=num; i>0; i--){
            list.add(i);
        }
        return list;
    }
    /**
     * use to test the utils of collections
     */
    public static void collectionsTest(){
        List<Integer> list = CollectionTest.constructList(4);
        Collections.addAll(list, 5, 6);
        System.out.println(list);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list);
    }

    public static void main(String[] args) {
        CollectionTest.collectionsTest();
    }
}
