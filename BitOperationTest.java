package zhang.algorithm.JavaTest;

/**
 * Created by zhang_zack on 16/5/28.
 * 用来验证Java中的位运算
 */
public class BitOperationTest {
    public static void main(String[] args) {
        System.out.println("5&4--->"+(5&4));//4
        System.out.println("5&1--->"+(5&1));//1

        //ASCII表128个字符
        char word = 'A';
        System.out.println("原始word--->"+Integer.toBinaryString(word));
        word ^= 256;
        System.out.println("异或之后word--->"+Integer.toBinaryString(word));

        word ^= 256;
        System.out.println("再次异或之后word--->"+word);

        //^表示异或运算,异或异或,相异则为佳.所以不同为1,相同为0
        //同一个数异或两遍值不变
        System.out.println(1^1);//0
        System.out.println(0^0);//0
        System.out.println(1^0);//1
        System.out.println(0^1);//1

    }
}