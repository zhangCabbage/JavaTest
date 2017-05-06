package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 * <p>
 * synchronized可以用来对[对象]、[class类]进行加锁, synchronized(this)代码块和同步方法的作用一致。
 * 下面主要验证锁对象的改变
 */
public class Thread4_synchronized {

    static class MyService {
        private String lock = "123";

        public void method1() {
            try {
                System.out.println("lock --> " + lock);
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " begin: " + System.currentTimeMillis());
                    lock = "456"; //更改所对象
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void method2() {
            System.out.println("lock --> " + lock);
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin: " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " end: " + System.currentTimeMillis());
            }
        }
    }

    static class MyThread1 extends Thread {
        MyService service;

        public MyThread1(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.method1();
        }
    }

    static class MyThread2 extends Thread {
        MyService service;

        public MyThread2(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.method2();
        }
    }

    public static void main(String[] args) {
        //Test2
//        try {
//            MyService service = new MyService();
//            MyThread1 thread1 = new MyThread1(service);
//            MyThread2 thread2 = new MyThread2(service);
//            thread1.start();
//            Thread.sleep(300);
//            thread2.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //这里可以看见在method1中lock更改, thread1和thread2是异步的,因为lock值不同
//        lock --> 123
//        Thread-0 begin: 1484569184950
//        lock --> 456
//        Thread-1 begin: 1484569185252
//        Thread-1 end: 1484569185252
//        Thread-0 end: 1484569186953


        //Test1
        MyService service = new MyService();
        MyThread1 thread1 = new MyThread1(service);
        MyThread2 thread2 = new MyThread2(service);
        thread1.start();
        thread2.start();

        //lock都为"123",导致竞争锁相同, 所以同步执行
//        lock --> 123
//        lock --> 123
//        Thread-0 begin: 1484569348319
//        Thread-0 end: 1484569350320
//        Thread-1 begin: 1484569350320
//        Thread-1 end: 1484569350320
    }
}
