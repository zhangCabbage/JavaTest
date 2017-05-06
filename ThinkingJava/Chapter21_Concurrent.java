package zhang.algorithm.JavaTest.ThinkingJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/11
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
public class Chapter21_Concurrent {

    static class RunTask implements Runnable {

        private static int count = 0;
        private final int taskId = count++;
        protected int countDown = 10;

        public RunTask() {
        }

        public RunTask(int countDown) {
            this.countDown = countDown;
        }

        @Override
        public void run() {
            while (--countDown > 0) {
                System.out.print("#" + taskId + "(" + countDown + "), ");
            }
            Thread.yield();
        }
    }

    /**
     * 使用callable返回值
     */
    static class CallTask implements Callable<String> {
        private static int count = 0;
        private final int taskId = count++;

        @Override
        public String call() throws Exception {
            return "#" + taskId + ", ";
        }
    }

    /**
     * 使用Executor
     * <p>
     * 1) 后台线程派生的线程仍是后台线程
     * 2) 后台线程在没有非后天线程之后, 会自动突然关闭。(假如后台线程中由try{...}catch(){...}finally{...}, 那么不会保证finally的执行)
     * 3) 线程的捕获异常问题: thread.setUncaughtExceptionHandler()
     * -----> 需要传递一个继承了Thread.UncaughtExceptionHandler, 实现其uncaughtException(Thread t, Throwable e)方法
     * 4) 共享资源的同步控制: synchronized 和 ReentrantLock(更灵活, 用来处理加锁的特殊情况)
     */
    public static void test1() throws ExecutionException, InterruptedException {
//        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new RunTask());
        }

        ArrayList<Future<String>> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            res.add(exec.submit(new CallTask()));  //一定要使用submit
        }
        for (Future<String> fs : res) {
            if (fs.isDone()) {
                System.out.print(fs.get());
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("before time: " + System.currentTimeMillis());
//        TimeUnit.MILLISECONDS.sleep(100); //毫秒
        TimeUnit.SECONDS.sleep(3); //秒
        System.out.println("after time: " + System.currentTimeMillis());
    }

    /**
     * 关于同步、i++、++i的问题
     */
    public static void test2() {
        int i = 1;
        i = i++;
        System.out.println("after i = i++, res: " + i);

        i = ++i;
        System.out.println("after i = ++i, res: " + i);
    }

    /**
     * ThreadLocal的使用
     * 每个Thread中存储一个ThreadLocal.ThreadLocalMap
     * 对于每个ThreadLocal存储时, 先获取当前线程的ThreadLocalMap, 并把自己作为key, 传入值作为value
     * 放入ThreadLocalMap中。
     * 其中key为一个weekReference对象, 可能回收来节约内存, 但是value却不是, 在set/get时候会检查是否有key==null, 清除value
     */
    public static void test3() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal() {
            @Override
            protected Integer initialValue() {
                return 12;
            }
        };
        System.out.println("threadlocal initial value --> " + threadLocal.get());
        threadLocal.set(34);
        System.out.println("threadlocal current value --> " + threadLocal.get());
    }

    /**
     * 关于CopyOnWriteArrayList的运行模式, 还有其实现中 Object[] 数组一定要是volatile修饰的!!
     *
     * @throws InterruptedException
     */
    public static void test4() throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int elem : list) {
                    System.out.println("thread1 elem --> " + elem);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("add 5 elem" + list.add(5));
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("remove 4th elem" + list.remove(4));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int elem : list) {
                    System.out.println("thread2 elem --> " + elem);
                }
            }
        }).start();
    }

    /**
     * 关于Concurrent并发包中部分的实现
     * 1) sun.misc.Unsafe的CAS(Compare And Swap)
     * 2) 关于AtomicInteger的实现
     * -----> AtomicInteger、AtomicLong、AtomicBoolean
     * -----> CAS实现的乐观锁
     * ------------> 1) 避免加锁导致的线程调度开销, 提高并发性能
     * ------------> 2) ABA的问题(CAS是相同非更改则替换, 但假如A -> B -> A, 虽然相同,但其实已经更改了)
     * ------------> 3) 循环开销大, 且只能用于单个共享变量的原子操作
     * 3) ConcurrentHashMap的实现, 基于CAS
     */
    public static void test5() {
        Map<String, String> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent("one", "123"));
        System.out.println(map.putIfAbsent("one", "123"));
//        map.put(null, ""); //error
//        map.put("", null); //error

//        sun.misc.Unsafe.getUnsafe(); //一般用户不能调用

    }

    /**
     * Lock and ReadWriteLock
     */
    public static void test6() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        try {

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void test7() {

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//        test3();
        test5();
//        test6();
    }
}
