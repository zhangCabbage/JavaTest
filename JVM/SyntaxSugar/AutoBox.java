package zhang.algorithm.JavaTest.JVM.SyntaxSugar;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/5
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public class AutoBox {
    /**
     * 关于自动拆装箱的验证
     * [浅谈Java自动装箱与拆箱及其陷阱](http://www.jb51.net/article/86373.htm)
     * Integer.valueOf(int i) 中 IntegerCache 会缓存 -128 - 127 的数字
     * <p>
     * 1) 基础类型 == 封装类, 封装类拆箱
     * 2) 封装类 == 封装类, 正常对象比较
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); //true
        System.out.println(e == f); //false
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a + b)); //true
        System.out.println(g == a + b); //true
        System.out.println(3.0 == 3); //true
        System.out.println(g.equals(a + b)); //false

        Integer h = null;
        int i = h;  //空指针异常
    }
}
