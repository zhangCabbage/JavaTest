package zhang.algorithm.JavaTest.DateTime;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/29
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public class DateTimeTest {

    public static void main(String[] args) {
        System.out.println(new Date().getTime() == System.currentTimeMillis());
    }
}
