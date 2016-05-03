package zhang.algorithm.JavaTest;

public class CallBackTest {
	public static void main(String[] args){
		//观察者大致的设计模式
		Boss boss = new Boss();
		boss.makeSoliderDoSomething();
	}
}


class Boss implements MyCallBack{
	private Solider solider;
	public Boss(){}
	
	public Boss(Solider solider){
		this.solider = solider;
	}
	
	public void makeSoliderDoSomething(){
		solider.doSomething(this);
	}
	
	@Override
	public void backResult() {
		System.out.println("被回调了");
	}
	
}

class Solider{
	
	public void doSomething(MyCallBack callback){
		//TODO
		callback.backResult();
	}
}