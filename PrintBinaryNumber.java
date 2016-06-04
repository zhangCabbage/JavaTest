package zhang.algorithm.JavaTest;

/**
 * Created by zhang_zack on 16/6/4.
 */
public class PrintBinaryNumber {
    public static void main(String[] args) {
        //十进制转二进制
        System.out.println(Integer.toBinaryString(7));
        //二进制转十进制
        System.out.println(Integer.parseInt("111", 2));

        //Java不显式的支持二进制,因为二进制太长
        int x = 0x11;//直接十六进制
        System.out.println(x);
        int y = 011;//直接八进制
        System.out.println(y);
    }
}
