package zhang.algorithm.JavaTest;

import java.util.HashMap;
import java.util.HashSet;

public class HashSet_HashMap {	
	public static void main(String args[]){
		int len = 10000000;
		//进行len次的添加和移除
		
		long set_start = System.currentTimeMillis();
		HashSet set = new HashSet();
		for(int i=0; i<len; i++){
			set.add(i);
		}
		for(int i=0; i<len; i++){
			set.remove(i);
		}
		long set_end = System.currentTimeMillis();
		System.out.println("set进行"+len+"次添加删除，总用时 --> "+(set_end-set_start));
		
		long map_start = System.currentTimeMillis();
		HashMap map = new HashMap();
		for(int i=0; i<len; i++){
			map.put(i, i);
		}
		for(int i=0; i<len; i++){
			map.remove(i);
		}
		long map_end = System.currentTimeMillis();
		System.out.println("map进行"+len+"次添加删除，总用时 --> "+(map_end-map_start));
	}
}
