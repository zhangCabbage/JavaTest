package zhang.algorithm.JavaTest.JVM;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 * <p>
 * 任何一个对象被GC回收,都需要经过两次标记
 * 1、使用可达性分析不可达, 那么会对此对象进行第一次标记, 并进行筛选
 * -----如果此对象 没有覆写finalize方法 或 finalize方法已经被虚拟机执行过一次, 那么没必要执行GC, 否则放入F-Queue中
 * 2、对F-Queue中的对象, 进行小范围标记, 如果某个对象与引用链上任一对象建立重新建立连接, 那么把它移除F-Queue
 * -----否则二次标记, 并最终对对象进行回收。
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, I am still alive, :) ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead, :( ");
        }


        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead, :( ");
        }

        //print:
        //finalize method executed!
        //Yes, I am still alive, :)
        //No, I am dead, :(

        //任何一个对象的finalize只能被系统自动调用一次
    }
}
