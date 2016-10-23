package zhang.algorithm.JavaTest.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 * <p>
 * 堆内存溢出测试
 * JVM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * -Xms 最小堆内存
 * -Xmx 最大堆内存, 不可扩展
 *
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<Object> list = new ArrayList();

        while (true) {
            list.add(new HeapOOM());
        }
    }
}
