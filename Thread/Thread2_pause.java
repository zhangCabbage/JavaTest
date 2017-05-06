package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class Thread2_pause {

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 0;
            while (true) {
                System.out.println("i --> " + ++i);
            }
        }
    }

    /**
     * 关于[使用suspend进行线程停止]和[使用resume进行线程恢复]
     * 它们有两个特点: 独占, 会导致数据不一致
     * 当在同步块内暂停, 线程不释放同步锁, 导致其他线程无法再使用此对象
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(500);
            thread.suspend();
            System.out.println("Main end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
