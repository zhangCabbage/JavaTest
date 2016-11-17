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
        map.put("zhang", "123");
        map.put("zhang", null);
        System.out.println(map.size());//2
        System.out.println(map.get("zhang"));

        Map<String, String> map2 = new Hashtable<String, String>();
//        map2.put(null, null);//java.lang.NullPointerException
//        map2.put("zhang", null);//java.lang.NullPointerException
        map2.put("zhang", "zhang");
        System.out.println(map2.size());
        System.out.println(map2.get("gao"));

    }
}

class ProtectedTest extends Object{
    protected void print(){
        System.out.println("ProtectedTest print!");
    }
}
