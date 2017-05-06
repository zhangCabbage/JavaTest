package zhang.algorithm.JavaTest.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 * <p>
 * volatile作用:
 * 变量在多线程中可见, 强制从公共堆栈中取得变量的值, 而不是从线程私有数据栈中取得变量的值
 * 但是其并不是原子操作!!
 * <p>
 * 注意: 这里面的可见性方式可能不太对!
 */
public class Thread5_volatile {
    //---------------------------------------------------------------------------------------------
    static class MyThread1 extends Thread {
        private AtomicInteger count = new AtomicInteger(0);//原子类整数
        volatile private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("Enter run...");
            while (isRunning) {
            }
            System.out.println("Outer run...");
        }
    }

    //---------------------------------------------------------------------------------------------
    static class MyThread2 extends Thread {
        private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("Enter run...");
            String anyString = new String();
            while (isRunning) {
                synchronized (anyString) {
                    //这里为什么任意一个都能实现同步可见?
                    //synchronized一方面使得多线程共享anyString锁对象这一资源时进行同步
                    //另一方面还可以将线程工作内存中的私有变量与公共内存中的变量同步!!
                    //这里即是第二个方面的作用, 同步isRunning变量。
                }
            }
            System.out.println("Outer run...");
        }
    }

    //---------------------------------------------------------------------------------------------
    static class MyThread3 extends Thread {
        private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("Enter run...");
            while (isRunning) {
                //为什么这里加上System.out.println, 就可以了呢?
                //原因跟上一个相同, 因为println函数里有synchronized (this)代码块
                System.out.println("...running");
            }
            System.out.println("Outer run...");
        }
    }

    public static void main(String[] args) {
        //Test1
//        try {
//            MyThread1 thread1 = new MyThread1();
//            thread1.start();
//            Thread.sleep(1000);
//            thread1.setRunning(false);
//            System.out.println("赋值thread isRunning is false!!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Test2
//        try {
//            MyThread2 thread2 = new MyThread2();
//            thread2.start();
//            Thread.sleep(1000);
//            thread2.setRunning(false);
//            System.out.println("赋值thread isRunning is false!!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Test3
//        try {
//            MyThread3 thread3 = new MyThread3();
//            thread3.start();
//            Thread.sleep(100);
//            thread3.setRunning(false);
//            System.out.println("赋值thread isRunning is false!!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
