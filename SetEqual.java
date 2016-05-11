package zhang.algorithm.JavaTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetEqual {
	public static void main(String[] args){
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(0);
		set1.add(-1);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(-1);
		set2.add(1);
		set2.add(0);
		System.out.println(set1.equals(set2));
		Map<Set<Integer>, Integer> map = new HashMap<Set<Integer>, Integer>();
		map.put(set1, 1);
		System.out.println(map.containsKey(set2));
	}
}
