package zhang.algorithm.JavaTest;

import java.util.Observable;
import java.util.Observer;

/**
 * Java自身内置Observer模式的使用，增加线程控制，会比自己写整合的更好
 * @author zhang_zack
 *
 */
public class JDKObserverTest {
	public static void main(String[] args){
		Publisher2 publisher = new Publisher2();
		Reader2 read1 = new Reader2();
		Reader2 read2 = new Reader2();
		publisher.addObserver(read1);
		publisher.addObserver(read2);
        publisher.publish("Kent.Kuan的技术空间");
	}
}

class Publisher2 extends Observable {
    
    private String magazineName;
    

    public String getMagazineName() {
        return magazineName;
    }
    
    public void publish(String magazineName) {
        this.magazineName = magazineName;
        setChanged();
        notifyObservers(this);
    }
    
}

class Reader2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Publisher2 p = (Publisher2) o;
        System.out.println("我要订阅" + p.getMagazineName());
    }

}
