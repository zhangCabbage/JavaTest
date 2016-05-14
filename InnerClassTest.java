package zhang.algorithm.JavaTest;

public class InnerClassTest {
	static class one{
		private static class two{
			public static void main(String[] args){
				System.out.println("two");
			}
		}
	}
}

class OuterClass{
	private String name="OuterClass";
	public static int number = 12;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class InnerClass{
		public static String name = "InnerClass";
	}
	
	public class InnerClass2{
		public void fun(){
			System.out.println(number);
		}
	}
}
