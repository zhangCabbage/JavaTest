package zhang.algorithm.JavaTest;

public class InitVariableTest {
//	//情况一
//	{
//		a = 1;
////		System.out.println(a);//为什么这里会出错
//	}
//	private int a = 2;
	
//	//情况二
//	private int a = 2;
//	{
//		a = 1;
//		System.out.println(a);//正常运行
//	}
	
//	//情况三
//	{
//		a = 4;
//		System.out.println("block --> "+a);//报错
//	}
//	private final int a;
	
//	//情况四
//	private final int a;
//	{
//		a = 4;
//		System.out.println("block --> "+a);//正常运行
//	}
	
//	//情况五
//	{
//		a = 4;
//		//可以，不报错
//		System.out.println("block --> "+a);
//	}
//	private static int a;
	
	//情况六
//	static{
//		a = 4;
//		System.out.println(a);//报错
//	}
//	private static int a;
	
	//情况七
	private static int a;
	static{
		a = 4;
		System.out.println(a);//正常
	}
	
	public static void main(String[] args){
//		System.out.println(InitVariableTest.a);
		InitVariableTest test = new InitVariableTest();
		System.out.println(test.a);//只能这样访问本身类
		ABC classA = new ABC();
//		System.out.println(classA.abc);//出错！
	}
}

class ABC{
	private int abc = 3;
}
