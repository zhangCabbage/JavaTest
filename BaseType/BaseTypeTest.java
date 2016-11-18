package zhang.algorithm.JavaTest.BaseType;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/18
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */
public class BaseTypeTest {

    public static void main(String[] args) {
        //0.4在计算机的二进制存储系统中无法精确表示
        //解决方法: 1)使用BigDecimal 2)先扩大成整数, 进行逻辑计算, 之后再缩小
        System.out.println(10.00 - 9.60); //0.40000000000000036
    }
}
