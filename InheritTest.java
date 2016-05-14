package zhang.algorithm.JavaTest;

/**
 * 用来验证继承、以及初始化的关系
 * @author zhang_zack
 * 
 */
public class InheritTest {
	public static void main(String[] args){
		new Y();//ZXZY，从输出结果来看优先给类中成员分配内存进行初始化，最后再执行构造函数
	}
}

class X{
	public X(){
		System.out.print("X");
	}
	Z z = new Z();//与成员变量的前后位置没有关系
}
class Y extends X{
	Z z = new Z();
	public Y(){
		System.out.print("Y");
	}
}
class Z{
	public Z(){
		System.out.print("Z");
	}
}
