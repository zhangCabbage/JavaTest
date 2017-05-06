package zhang.algorithm.JavaTest.ThinkingJava;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/5
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
public class Chapter17_DepCollection {

    private static class VeryBig {
        public String indent;

        public VeryBig(String indent) {
            this.indent = indent;
        }

        @Override
        public String toString() {
            return "VeryBig{" +
                    "indent='" + indent + '\'' +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize ---> " + indent);
            super.finalize();
        }
    }

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue();

    private static void checkQueue() {
        Reference<? extends VeryBig> ref = rq.poll();
        if (ref != null) {
            System.out.println("queue --> " + ref.get());
        }
    }

    private static void referenctTest() {
        LinkedList<SoftReference<VeryBig>> list1 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(new SoftReference<VeryBig>(new VeryBig(String.valueOf(i)), rq));
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> list2 = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            list2.add(new WeakReference<VeryBig>(new VeryBig(String.valueOf(i)), rq));
            checkQueue();
        }

        System.gc();
        System.out.println("result --> " + list2.get(2).get()); //null
    }

    public static void mapTest() {
        Hashtable<String, String> table = new Hashtable<>();
//        table.put(null, "");
//        table.put("", null);

        HashMap<String, String> map = new HashMap<>();
        map.put(null, "");
        map.put("", null);
    }

    public static void main(String[] args) {
//        referenctTest();
        mapTest();
    }


}
