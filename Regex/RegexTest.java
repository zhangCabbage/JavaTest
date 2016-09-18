package zhang.algorithm.JavaTest.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    /**
     * 用来验证正则提取某个特定的数字
     */
    public static void fun1() {
        Pattern p = Pattern.compile("\"size\"\\: (\\d)");
        String s = "],\"size\": 2, \"code\": 0}";
        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            System.out.println("m.group():" + matcher.group()); //打印所有
            System.out.println("m.group(1):" + matcher.group(1)); //打印数字
        }
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d+\\,)(\\d+)");
        System.out.println("(\\d+\\,)(\\d+)");
        String s = "123,456-34,345";
        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            System.out.println("m.group():" + matcher.group()); //打印所有
            System.out.println("m.group(1):" + matcher.group(1)); //打印数字
            System.out.println("m.group(2):" + matcher.group(2)); //打印字母的
            System.out.println();
        }


    }
}
