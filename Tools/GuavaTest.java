package zhang.algorithm.JavaTest.Tools;

import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/7
 * Time: 下午10:28
 * To change this template use File | Settings | File Templates.
 */
public class GuavaTest {
    /**
     * string
     */
    public static void guavaStr() {
        //join
        String[] joinStrs = {"one", "two", null, "three"};
        String joinRes = Joiner.on("、").skipNulls().join(joinStrs);
        System.out.println(joinRes);//one、two、three

        //split
        String splitStr = ",a,,b,c,";
        Iterable<String> splitRes = Splitter.on(",").trimResults().omitEmptyStrings().split(splitStr);
        System.out.println(splitRes);//[a, b, c]

        //charMatcher
        String matchStr = "zhang1gao2hai";
        String matchRes = CharMatcher.anyOf("aeiou").or(CharMatcher.DIGIT).replaceFrom(matchStr, "|");
        System.out.println(matchRes);//zh|ng|g|||h||

        //Strings, last function of this here is need to an
        System.out.println(Strings.padStart("5", 4, '0'));//0005
        System.out.println(Strings.padEnd("4.", 5, '0'));//4.000
        System.out.println(Strings.repeat("Nice ", 3));//Nice Nice Nice
        System.out.println(Strings.commonPrefix("zhang12", "zhang34"));//zhang
        System.out.println(Strings.commonSuffix("zhang12", "gao12"));//12
    }

    /**
     * Math
     */
    public static void guavaMath() {
        //二项式系数
        System.out.println(IntMath.binomial(4, 1));//4

    }

    /**
     * ordering
     */
    public static void guavaOrdering() {
        Function<Foo, String> function = new Function<Foo, String>() {

            @Override
            public String apply(Foo foo) {
                return foo.name;
            }
        };
        Ordering ordering = Ordering.natural().nullsFirst().onResultOf(function);
        Foo[] foos = new Foo[4];
        foos[0] = new Foo("one", 1);
        foos[1] = new Foo("two", 2);
        foos[2] = new Foo("three", 3);
        foos[3] = new Foo("four", 4);
        ordering.min(Arrays.asList(foos));
    }

    /**
     * 前置条件
     */
    public static void guavaCheck() {
        Preconditions.checkElementIndex(4, 5);
    }

    /**
     * Objects对象
     */
    public static void guavaObjects() {
        System.out.println(Objects.equal("null", null));//此方法jdk7之后util中已提供
    }

    /**
     * collections
     */
    public static void guavaCollections() {
        List<String> list1 = Lists.newArrayList("1", "2", "3");
        List<String> list2 = Lists.newArrayListWithCapacity(10);
    }

    public static void main(String[] args) {
        GuavaTest test = new GuavaTest();
        guavaStr();
        guavaMath();
        guavaOrdering();
        guavaCheck();
    }

    static class Foo implements Comparable<Foo> {
        String name;
        int age;

        public Foo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Foo foo) {
            return ComparisonChain.start()
                    .compare(this.name, foo.name)
                    .compare(this.age, foo.age)
                    .result();
        }
    }
}