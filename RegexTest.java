package zhang.algorithm.JavaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args){
		// 按指定模式在字符串查找
//	      String line = "This order was placed for QT3000! OK?";
//	      String pattern = "(.*)(\\d+)(.*)";
//
//	      // 创建 Pattern 对象
//	      Pattern r = Pattern.compile(pattern);
//	      // 现在创建 matcher 对象
//	      Matcher m = r.matcher(line);
//	      
//	      if (m.find()) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	      } else {
//	         System.out.println("NO MATCH");
//	      }
	      
	      
	      Pattern p = Pattern.compile("(\\d+\\,)(\\d+)");
	      System.out.println("(\\d+\\,)(\\d+)");
	      String s = "123,456-34,345";
	      Matcher matcher = p.matcher(s);
	      if(matcher.find())
	      {
	    	  System.out.println("m.group():"+matcher.group()); //打印所有 
              System.out.println("m.group(1):"+matcher.group(1)); //打印数字
              System.out.println("m.group(2):"+matcher.group(2)); //打印字母的
              System.out.println();
	      }  
	}
}
