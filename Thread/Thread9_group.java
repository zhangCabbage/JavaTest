package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/18
 * Time: 下午10:21
 * To change this template use File | Settings | File Templates.
 * <p>
 * group.activeGroupCount() 获取的是当前线程组下所有的(子孙后代)活跃线程组数
 * [JVM的跟线程组为System]
 */
public class Thread9_group {

    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup groupA = new ThreadGroup(mainGroup, "A");
        ThreadGroup groupB = new ThreadGroup(groupA, "B");
        System.out.println("main group's active group count --> " + mainGroup.activeGroupCount());
        System.out.println("A group's active group count --> " + groupA.activeGroupCount());
    }
}
