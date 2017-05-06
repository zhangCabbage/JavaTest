package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class Thread3_daemon {

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 0;
            try {
                while (true) {
                    i++;
                    System.out.println("i --> " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);  //必须在start之前, setDaemon
            thread.start();
            Thread.sleep(8000);
            System.out.println("main线程结束!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
