package zhang.algorithm.JavaTest.JVM.Exception;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/5
 * Time: 下午7:01
 * To change this template use File | Settings | File Templates.
 */
public class RunTimeError {

    public static void main(String[] args) {
        //数组size为负, 这是一个运行时异常
        int[][] arr = new int[-1][2];
    }
}
