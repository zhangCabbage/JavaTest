package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/19
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 * 1>
 * 没啥新内容:
 * 如果线程异常处理截取异常, 那么静态和线程组异常就不起作用
 * 如果没有线程异常处理, 那么先进行静态异常处理, 之后进行线程组异常处理
 */
public class Thread10_exception {

    static class MyThread extends Thread {
        private String num = "a";

        public MyThread(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            super.run();
            int numInt = Integer.parseInt(num);
            System.out.println("在线程中打印 --> " + (numInt + 1));
        }
    }

    static class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("对象异常处理");
            e.printStackTrace();
        }
    }

    static class StaticUncaughtException implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("静态异常处理");
            e.printStackTrace();
        }
    }

    static class MyThreadGroup extends ThreadGroup {
        public MyThreadGroup(String name) {
            super(name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            super.uncaughtException(t, e);
            System.out.println("线程组异常处理");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("我的线程组");

        MyThread thread = new MyThread(threadGroup, "我的线程");
        MyThread.setDefaultUncaughtExceptionHandler(new StaticUncaughtException());
//        thread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());

        thread.start();
    }
}
