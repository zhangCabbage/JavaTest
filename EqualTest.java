package zhang.algorithm.JavaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用来验证集合类的相等关系
 * @author zhang_zack
 *
 */
public class EqualTest {
	private String name;
	public EqualTest(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj instanceof EqualTest){
			EqualTest test = (EqualTest) obj;
			return this.name.equals(test.name);
		}
		return false;
	}

	public static void main(String[] args){
		List<EqualTest> list = new ArrayList<EqualTest>();
		EqualTest test1 = new EqualTest("test");
		EqualTest test2 = new EqualTest("test");
		Object test3 = new EqualTest("test");
		list.add(test1);
		System.out.println(list.contains(test2));
		System.out.println("test1.equals(test2) ---> "+test1.equals(test2));
		System.out.println("test2.equals(test3) ---> "+test2.equals(test3));
		System.out.println("test3.equals(test2) ---> "+test3.equals(test2));
		
		System.out.println("----------------");
		zhangNumber1 number1 = new zhangNumber1(3, 20);
		zhangNumber1 number2 = new zhangNumber1(3, 22);
		System.out.println(number1.equals(number2));
		Set<zhangNumber1> set = new HashSet<zhangNumber1>();
		set.add(number1);
		//HashSet使用contains判断两个元素是否相同，不仅需要equals相等，还需要hashCode相同
		System.out.println("set.contains(number2) ---> "+set.contains(number2));
		set.add(number2);
		System.out.println(set);

		System.out.println("----------------");
		zhangNumber2 number3 = new zhangNumber2(3, 20);
		zhangNumber2 number4 = new zhangNumber2(4, 22);
		System.out.println(number3.equals(number4));
		Map<zhangNumber2, Integer> map2 = new HashMap<zhangNumber2, Integer>();
		map2.put(number3, 1);
		//HashSet使用contains判断两个元素是否相同，不仅需要equals相等，还需要hashCode相同
		System.out.println("map.get(number4) ---> "+map2.get(number4));
		map2.put(number4, 2);
		System.out.println(map2.size());

		
		//String虽然是引用类型，但是使用起来跟基本类型是一样的
		Map<String, String> map = new HashMap<String, String>();
		map.put("ab", "1");
		System.out.println(map.containsKey("a"+"b"));//true
		System.out.println(map.get("a"+"b"));//1
		String str1 = "ab";
		String str2 = "a"+"b";
		String str3 = "a";
		String str4 = "b";
		System.out.println("str1==str2 ---> "+(str1==str2));//true
		System.out.println(str1==str3+str4);//false
		System.out.println(str1=="a"+str4);//false
		System.out.println(str1.equals(str3+str4));//true
		
		
	}
}

class zhangNumber1 {
	public int num;
	public int age;
	public zhangNumber1(int num, int age){
		this.num = num;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj instanceof zhangNumber1){
			zhangNumber1 number = (zhangNumber1) obj;
			return this.num==number.num;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return num+age;
	}
}

class zhangNumber2{
	public int num;
	public int age;
	public zhangNumber2(int num, int age){
		this.num = num;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj instanceof zhangNumber1){
			zhangNumber1 number = (zhangNumber1) obj;
			return this.num==number.num;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return 123;
	}

	@Override
	public String toString() {
		return "num "+num+", age "+age;
	}
}


