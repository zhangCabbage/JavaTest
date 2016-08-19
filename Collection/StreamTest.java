package zhang.algorithm.JavaTest.Collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/21
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class StreamTest {
    /**
     * 这里Arrays.asList(strs), 那么对list的修改就是对String 数组的修改
     */
    public static void sortTest() {
        String[] strs = {"987", "567", "888"};

        List<String> list = Arrays.asList(strs);
        //normal format
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                System.out.println("str1-->" + str1 + ", str2-->" + str2 + ", result : " + str1.compareTo(str2));
                return str1.compareTo(str2);
            }
        });

        System.out.println("collections sort list --> " + list); //rusult is [567, 888, 987]
        System.out.println("original array -->  " + Arrays.toString(strs)); //rusult is [567, 888, 987]

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return -str1.compareTo(str2);
            }
        });
        System.out.println("Arrays sort --> " + Arrays.toString(strs));//[987, 888, 567]
    }

    public static void lambdaTest() {
        System.out.println();
        System.out.println("--- Lambda Test ---");

        String[] names = {"zhang", "li", "wang"};
        Stream<String> nameStream = Arrays.asList(names).stream();
        nameStream.forEach(System.out::println);

        Stream<Integer> ageStream = Arrays.asList(1, 2, 3, 4).stream();
        List<Integer> ageList = ageStream.filter(x -> x > 2).map(x -> x * x).collect(Collectors.toList());
        System.out.println(ageList);

        List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int finalSum = ints.stream().reduce((sum, item) -> sum + item).get();
        System.out.println("stream reduce to sum is --> " + finalSum);

        System.out.println("stream allMatch --> " + ints.stream().allMatch(item -> item < 100));
        ints.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);
        //ifPresent 如果存在, 那么进行后面的函数操作, 否则该干啥干啥

        List<String> wordList = Lists.newArrayList("zhang", "li", "wang");
        Stream<String> wordStream = wordList.stream();
        wordList.add("number");
        System.out.println("stream distinct --> " + wordStream.distinct().count());

        // ConcurrentModificationException
        //Stream不存储数据,数据存储在collection中,所以在操作stream时,不能修改collection数据
//        Stream<String> wordStream2 = wordList.stream();
//        wordStream2.forEach(s -> {
//            if (s.length() >= 6) wordList.remove(s);
//        });

        System.out.println(Stream.of("You", "may", "assume").collect(Collectors.joining()));
        //返回 String 类型 : Youmayassume
        System.out.println(Stream.of("You", "may", "assume").collect(Collectors.joining(", ")));
        //返回 String 类型You, may, assume

        IntSummaryStatistics summary = Stream.of("You", "may", "assume")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(summary.getMax());
        //IntSummaryStatistics获得当前整型list数组的统计信息
        //包括 : 最大Max, 最小Min, 平均Average, 个数Count, 元素总和Sum

        String res = Stream.of("Your", "may", "assume").sorted(Comparator.comparing(String::length)).collect(Collectors.joining());
        System.out.println(res); //mayYourassume

        Map<Integer, List<String>> resMap1 = Stream.of("Your", "may", "hello", "world").collect(Collectors.groupingBy(String::length));
        System.out.println(resMap1); //{3=[may], 4=[Your], 5=[hello, world]}
        Map<Integer, Long> resMap2 = Stream.of("Your", "may", "hello", "world").collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(resMap2); //{3=1, 4=1, 5=2}
    }

    public static void main(String[] args) {

        sortTest();

        lambdaTest();
    }
}
