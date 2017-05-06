package zhang.algorithm.JavaTest.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/18
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 * 1>
 * 使用lock来进行加锁: 对同一个lock锁, 任意时刻只有一个线程能进入lock.lock()和lock.unlock()区域。
 * 2>
 * ReentrantReadWriteLock读写锁, 读锁: lock.readLock(), 写锁: lock.writeLock()
 * 读写互斥, 写写互斥, 读读共享
 */
public class Thread7_lock {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
    }
}
