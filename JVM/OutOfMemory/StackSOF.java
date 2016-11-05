package zhang.algorithm.JavaTest.JVM.OutOfMemory;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 * <p>
 * JVM栈深度请求超出最大深度, StackOverflowError
 * -Xss160k
 * <p>
 * -Xss设置JVM栈的内存容量
 */
public class StackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        this.stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF test = new StackSOF();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length is --> " + test.stackLength);
            throw e;
        }
    }
}
