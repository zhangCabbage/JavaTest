package zhang.algorithm.JavaTest;

import java.util.ArrayList;

public class FinalTest {
	
	public final int MAX;
	public static final ArrayList<Integer> myList = new ArrayList<>();
	public FinalTest(int x){
		MAX = x;
	}
	public static void main(String[] args){
		FinalTest.myList.add(1);
		FinalTest.myList.add(2);
		System.out.println(FinalTest.myList);
	}
}

/**
 * 实现线程安全的单例模式
 * @author zhang_zack
 *
 */
class ThreadSafeSingleton{
	private ThreadSafeSingleton(){}
	//静态内部类实现线程安全的单例模式
	private static class LazyHolder{
		private static ThreadSafeSingleton SINGLE = new ThreadSafeSingleton();
	}
	public static final ThreadSafeSingleton getInstance(){
		return LazyHolder.SINGLE;
	}
}

/**
 * 饿汉式单例模式
 * @author zhang_zack
 *
 */
class OneSingleton{
	private OneSingleton(){};
	private static OneSingleton singleton = new OneSingleton();
	public static OneSingleton getInstance(){
		return singleton;
	}
}

/**
 * 懒汉式改进双检查锁+volatile实现线程同步
 * @author zhang_zack
 *
 */
class TwoSingleton{
	private TwoSingleton(){};
	private volatile static TwoSingleton singleton = null;
	public static TwoSingleton getInstance(){
		//双重检查
		if(singleton == null){
			synchronized (TwoSingleton.class) {
				if(singleton == null){
					singleton = new TwoSingleton();
				}
			}
		}
		return singleton;
	}
}

