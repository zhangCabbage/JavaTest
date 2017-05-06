package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/16
 * Time: 上午9:47
 * To change this template use File | Settings | File Templates.
 * <p>
 * 关于此线程程序,参看【Java多线程编程核心技术】
 */
public class Thread0_getName {

    static class CountOperate extends Thread {
        public CountOperate() {
            System.out.println("CountOperate ---> begin");
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
            System.out.println("This.getName() = " + this.getName());
            System.out.println("This.isAlive() = " + this.isAlive());
            System.out.println("CountOperate ---> end");
        }

        @Override
        public void run() {
            super.run();
            System.out.println("Run ---> begin");
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
            System.out.println("This.getName() = " + this.getName());
            System.out.println("This.isAlive() = " + this.isAlive());
            System.out.println("Run ---> end");
        }
    }


    /**
     * 注意:
     * 为什么this.getName和Thread.currentThread().getName不同
     * 为什么this.isAlive和Thread.currentThread().isAlive不同
     *
     * @param args
     */
    public static void main(String[] args) {
        //Test1
        CountOperate c = new CountOperate();
        Thread thread = new Thread(c);
        thread.setName("A");
        thread.start();

//        CountOperate ---> begin
//        Thread.currentThread().getName() = main
//        Thread.currentThread().isAlive() = true
//        This.getName() = Thread-0
//        This.isAlive() = false
//        CountOperate ---> end
//        Run ---> begin
//        Thread.currentThread().getName() = A
//        Thread.currentThread().isAlive() = true
//        This.getName() = Thread-0
//        This.isAlive() = false
//        Run ---> end

    }
}
