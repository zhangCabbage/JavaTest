package zhang.algorithm.JavaTest.JVM.GC;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/29
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 * <p>
 * JVM参数为:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * -verbose:gc
 * -XX:+PrintGCDetails   表示打印GC信息
 */
public class MemAllocAndGC {

    private static int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        MemAllocAndGC test = new MemAllocAndGC();
        byte[] alloc1, alloc2, alloc3, alloc4;
        alloc1 = new byte[2 * _1MB];
        alloc2 = new byte[2 * _1MB];
        alloc3 = new byte[2 * _1MB];
        alloc4 = new byte[4 * _1MB];
    }
}
