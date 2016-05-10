package zhang.algorithm.JavaTest;

public class InnerClassTest {
	
}

class OuterClass{
	private String name="OuterClass";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static class InnerClass{
		public static String name = "InnerClass";
	}
}
