package zhang.algorithm.JavaTest;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 观察者模式测试
 * @author zhang_zack
 *
 */
public class OberserPatternTest {
	public static void main(String[] args){
		Publisher p = new Publisher();
		Reader read1 = new Reader();
		Reader read2 = new Reader();
		p.registerObserver(read1);
		p.registerObserver(read2);
		p.notifyAllObservers();
	}
}


interface MyObserver {
	public void update(MySubject s);
}

interface MySubject{
	public void registerObserver(MyObserver o);
    public void removeObserver(MyObserver o);
    public void notifyAllObservers();
}

//分别实例化一个Subject类和n多观察者类，分别实现handEvent方法。
class Publisher implements MySubject{
	private ArrayList<MyObserver> observerList = new ArrayList<MyObserver>();
	public String name = "zhang";
	@Override
	public void registerObserver(MyObserver o) {
		observerList.add(o);
	}

	@Override
	public void removeObserver(MyObserver o) {
		observerList.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		Iterator<MyObserver> iterator = observerList.iterator();
		while(iterator.hasNext()){
			((MyObserver)iterator.next()).update(this);;
		}
	}
	
}

class Reader implements MyObserver{

	@Override
	public void update(MySubject s) {
		Publisher p = (Publisher)s;
		System.out.println(p.name);
	}
	
}