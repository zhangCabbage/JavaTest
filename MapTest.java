package zhang.algorithm.JavaTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * HashMap和Hashtable的区别
 *
 * @author zhang_zack
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, null);
        map.put("zhang", null);
        map.put("gao", null);
        System.out.println(map.size());//3

        Map<String, String> map2 = new Hashtable<String, String>();
//        map2.put(null, null);//java.lang.NullPointerException
//        map2.put("zhang", null);//java.lang.NullPointerException
        map2.put("zhang", "zhang");
        System.out.println(map2.size());
        System.out.println(map2.get("gao"));
    }
}
