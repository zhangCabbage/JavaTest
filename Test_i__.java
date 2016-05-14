package zhang.algorithm.JavaTest;

public class Test_i__ {
	public static void main(String args[]){
		//验证java中间变量缓存机制
		int j=0;
		for(int i=0; i<100; i++){
			j=j++;
		}
		System.out.println(j);//0
		
		
		char c = 48;
		System.out.println(c);//'0'
		System.out.println(0+'0');//48，输出int类型
		
		
		System.out.println(-5/2);//-2
		System.out.println(-5%2);//-1
		System.out.println(5/-2);//-2
		System.out.println(5%-2);//1
	}
}
