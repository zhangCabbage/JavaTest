package zhang.algorithm.JavaTest;

/**
 * 最近有点迷糊，虽然一个程序中会有多个线程同时运行，但是<strong>每个线程内的逻辑是顺序执行的</strong><br/>
 * 线程会因为时间片轮转而交叉着执行，当两个线程有公用资源的时候，就会出现需要同步的问题！<br/>
 * 否则，并没有干扰！！<br/>
 * @author zhang_zack
 *
 */
public class ThreadTest {
	
	public static void main(String[] args){
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();
	}
}


class Thread1 extends Thread{

	@Override
	public void run() {
		for(int i=0; i<30; i++){
			System.out.println("this is Thread1---------------"+", "+i);
		}
		super.run();
	}
	
}

class Thread2 extends Thread{

	@Override
	public void run() {
		for(int i=0; i<30; i++){
			System.out.println("---------------this is Thread2"+", "+i);
		}
		super.run();
	}
	
}