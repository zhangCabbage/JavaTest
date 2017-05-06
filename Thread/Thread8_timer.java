package zhang.algorithm.JavaTest.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/18
 * Time: 下午8:14
 * To change this template use File | Settings | File Templates.
 * <p>
 * Timer管理定时任务
 * TimerTask具体定时任务内容, 继承了Runnable接口的抽象类
 */
public class Thread8_timer {
    private static Timer timer = new Timer();

    static class MyTask1 extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("run begin " + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("run end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTask2 extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("run begin " + System.currentTimeMillis());
                timer.cancel();
                Thread.sleep(3000);
                System.out.println("run end " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTask3 extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("run begin..." + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("run end..." + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Test1
        //如果cancel后执行的话,就没什么作用, 因为schedule和cancel会竞争queue资源
//        try {
//            MyTask1 timerTask = new MyTask1();
//            timer.schedule(timerTask, new Date());
//            Thread.sleep(100);
//            timer.cancel();
//            System.out.println("main end..." + System.currentTimeMillis());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Test2
        //timer.cancel()还是会执行完当前任务
//        MyTask2 timerTask = new MyTask2();
//        timer.schedule(timerTask, new Date());
//        System.out.println("main end..." + System.currentTimeMillis());

        //Test3
        //验证scheduleAtFixedRate具有追赶性, 只有当有滞后执行(设置时间早于当前时间)时才会进行追赶性
        MyTask3 timerTask = new MyTask3();
        Date date = new Date();
        try {
            //不知道这里是啥原因可能有报错的情况!!
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.parse("2016-11-12 09:14:21");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.scheduleAtFixedRate(timerTask, date, 3000);
    }
}
