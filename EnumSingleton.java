package zhang.algorithm.JavaTest;

/**
 * 利用枚举类实现单例模式，是最佳实践方式
 * @author zhang_zack
 *
 */
public enum EnumSingleton {
	INSTANCE1, INSTANCE2;
	
	private String name;
	private int age;
	
	public EnumSingleton getInstance(){
		return INSTANCE1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "name："+name+"，age："+age;
	}
	
	public static void main(String[] args){
		System.out.println("Hello World!");
		System.out.println("==========================");
		EnumSingleton test1 = EnumSingleton.INSTANCE1.getInstance();
		test1.setName("zhang");
		test1.setAge(23);
		System.out.println(test1);
		EnumSingleton test2 = EnumSingleton.INSTANCE1.getInstance();
		System.out.println(test2);
		System.out.println(test1==test2);
		System.out.println(EnumSingleton.INSTANCE2);
	}
	
}