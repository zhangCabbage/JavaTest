package zhang.algorithm.JavaTest.Collection;

import java.util.*;

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


    public static void main(String[] args) throws CloneNotSupportedException {
        // 1)
        CollectionTest.collectionsTest();

        // 2) 数组copy为浅拷贝
        //Color[]为对象, 其属性为Color, 而copyof为浅拷贝, 与Color是否实现拷贝接口无关
        Color[] colors1 = new Color[7];
        for (int i = 0; i < 7; i++) {
            colors1[i] = new Color(i, i);
        }
        Color[] colors2 = Arrays.copyOf(colors1, colors1.length);
        colors2[0].x = 100;
        System.out.println(Arrays.toString(colors1));//[(100, 0), (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6)]

        // 对比
        //对象的拷贝(浅拷贝)
        Color color1 = new Color(10, 10);
        Color color2 = (Color) color1.clone();
        color2.x = 100;
        System.out.println(color1);//(10, 10)

        // 3) 对象的比较
        Object[] object1 = {};
        Object[] object2 = {};
        System.out.println(object1 == object2);//false

        // 4) aslist
        Integer[] nums = {1, 2, 3};
        List<Integer> list = Arrays.asList(nums);
        list.add(4); //java.lang.UnsupportedOperationException
    }
}

class Color implements Cloneable {
    public int x;
    public int y;

    public Color(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}