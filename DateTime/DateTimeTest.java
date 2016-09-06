package zhang.algorithm.JavaTest.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/29
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public class DateTimeTest {
    /**
     *
     */
    public static void calendarTest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, -1); //在天数上加减
        System.out.println(format.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 3); //在月上加减
        System.out.println(format.format(calendar.getTime()));

        calendar.add(Calendar.YEAR, 3); //在年上加减
        System.out.println(format.format(calendar.getTime()));
    }

    public static void main(String[] args) {
        calendarTest();
    }
}
