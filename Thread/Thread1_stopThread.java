package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class Thread1_stopThread {
    //--------------------------------------------------------------------------------
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100000; i++) {
                System.out.println("i ---> " + (i + 1));
            }
        }
    }

    //--------------------------------------------------------------------------------
    static class MyThread2 extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("线程停止状态, 我要退出!");
                    break;
                }
                System.out.println("i ---> " + (i + 1));
            }
            System.out.println("balabala, 我在for下面");
        }
    }

    //--------------------------------------------------------------------------------
    static class MyThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 100000; i++) {
                    if (Thread.interrupted()) {
                        System.out.println("线程停止状态, 我要退出!");
                        throw new InterruptedException();
                    }
                    System.out.println("i ---> " + (i + 1));
                }
                System.out.println("balabala, 我在for下面");
            } catch (InterruptedException e) {
                System.out.println("退出 -- " + this.isInterrupted());
//                e.printStackTrace();
            }
        }
    }

    //--------------------------------------------------------------------------------

    /**
     * 先sleep, 之后interrupt
     */
    static class MyThread4 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                System.out.println("run begin...");
                Thread.sleep(20000);
                System.out.println("run end!");
            } catch (InterruptedException e) {
                System.out.println("在沉睡中被停止 -- " + this.isInterrupted());
                e.printStackTrace();
            }
        }
    }

    //--------------------------------------------------------------------------------

    /**
     * 先interrupt, 之后sleep(为什么可以这样, interrupt并不能使线程停止, 所以可以如此)
     */
    static class MyThread5 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("i ---> " + (i + 1));
                }
                System.out.println("run begin...");
                Thread.sleep(20000);
                System.out.println("run end!");
            } catch (InterruptedException e) {
                System.out.println("先interrupt再sleep, 则异常进入catch -- " + this.isInterrupted());
                e.printStackTrace();
            }
        }
    }

    //--------------------------------------------------------------------------------
    static class MyThread6 extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 0;

            try {
                while (true) {
                    System.out.println("i --> " + (++i));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //--------------------------------------------------------------------------------

    /**
     * 为什么不建议使用stop来停止线程
     */
    static class MyThread7 extends Thread {
        SynchronizeedObject object;

        public MyThread7(SynchronizeedObject object) {
            super();
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            this.object.printString("b", "bb");
        }
    }

    static class SynchronizeedObject {
        private String username = "a";
        private String password = "aa";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        synchronized public void printString(String username, String password) {
            try {
                this.setUsername(username);
                Thread.sleep(20000);
                this.setPassword(password);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //--------------------------------------------------------------------------------Main
    public static void main(String[] args) {
        //Test2, interrupt() can not to make run to stop
//        MyThread1 thread = new MyThread1();
//        thread.start();
//        thread.interrupt();
//        System.out.println("thread.interrupt run!");

        //线程先sleep, 后interrupt
//        try {
//            MyThread4 thread = new MyThread4();
//            thread.start();
//            Thread.sleep(100);
//            thread.interrupt();
//            System.out.println("thread.interrupt run!");
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }

        //线程先interrupt, 后sleep, 异常
        MyThread5 thread = new MyThread5();
        thread.start();
        thread.interrupt();
        System.out.println("thread.interrupt run!");

        //stop停止线程
//        try {
//            MyThread6 thread = new MyThread6();
//            thread.start();
//            Thread.sleep(8000);
//            thread.stop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //stop停止线程可能导致数据不一致
//        try {
//            SynchronizeedObject object = new SynchronizeedObject();
//            MyThread7 thread = new MyThread7(object);
//            thread.start();
//            Thread.sleep(500);
//            thread.stop();
//            System.out.println("username --> " + object.getUsername() + ", password -->" + object.getPassword());
////            username --> b, password -->aa
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
