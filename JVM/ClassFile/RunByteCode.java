package zhang.algorithm.JavaTest.JVM.ClassFile;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/29
 * Time: 下午8:45
 * To change this template use File | Settings | File Templates.
 */
public class RunByteCode {
    /**
     * @return
     */
    public static int tryTest() {
        int x;
        try {
            x = 1;
            return x;  //if ok, return 1
        } catch (Exception e) {
            x = 2;
            return x;  //if exception, return 2
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(tryTest());
    }
}
