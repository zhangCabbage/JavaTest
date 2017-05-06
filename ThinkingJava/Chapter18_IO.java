package zhang.algorithm.JavaTest.ThinkingJava;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/9
 * Time: 上午10:18
 * To change this template use File | Settings | File Templates.
 * <p>
 * 关于BufferedInputStream缓冲对IO读取速度的提升表示疑问?
 * 我们不是自己都可以使用数组来进行read(array)来缓冲么, 主要在BufferedInputStream方法重写了read()函数
 */
public class Chapter18_IO {

    public static void fileTest() {
        File oldFile = new File("/Users/zhang_zack/Desktop/zhang/test1");
        File newFile = new File("/Users/zhang_zack/Desktop/zhang/test2");
        System.out.println(oldFile.mkdirs()); //创建zhang/test2/文件
        System.out.println(oldFile.exists());
        System.out.println(oldFile.renameTo(newFile));
    }

    /**
     * NIO -> new I/O
     * reference: http://blog.csdn.net/suifeng3051/article/details/48160753
     *
     * @throws IOException
     */
    public static void nioTest() throws IOException {
        FileChannel inChannel = new FileInputStream("inputFile").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        inChannel.read(buffer);  //通道读, 对于buffer来说是写

        buffer.flip();

        FileChannel outChannel = new FileOutputStream("outputFile").getChannel();
        outChannel.write(buffer);

        //结束
        buffer.clear();
        inChannel.close();
        outChannel.close();
    }

    public static void serializableTest() throws IOException, ClassNotFoundException {
        //把对象序列化写到字节数组中
//        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//        ObjectOutputStream out = new ObjectOutputStream(byteArray);
//        out.writeObject("serializable object");
//        byteArray.toByteArray();

        class A implements Serializable {
        }
        class B implements Serializable {
            public String one;
            public A a;

            public B(String one, A a) {
                this.one = one;
                this.a = a;
            }

            @Override
            public String toString() {
                return "B{" +
                        "one='" + one + '\'' +
                        ", a=" + a +
                        '}';
            }
        }

        List<B> list = new ArrayList<>();
        list.add(new B("one", new A()));
        list.add(new B("two", new A()));
        list.add(new B("three", new A()));

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArray);
        outputStream.writeObject(list);
        outputStream.writeObject(list);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray.toByteArray()));
        List one = (List) inputStream.readObject();
        List two = (List) inputStream.readObject();
        System.out.println("one --> " + one);
        System.out.println("two --> " + two);
        System.out.println("one == two --> " + (one == two));

//        one --> [B{one='one', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@7a81197d}, B{one='two', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@5ca881b5}, B{one='three', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@24d46ca6}]
//        two --> [B{one='one', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@7a81197d}, B{one='two', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@5ca881b5}, B{one='three', a=zhang.algorithm.JavaTest.ThinkingJava.Chapter18_IO$1A@24d46ca6}]
//        one == two --> true
    }

    /**
     * 这里使用XOM开源xml库
     */
    public static void xmlTest() {

    }

    /**
     * 使用方法参见: http://www.cnblogs.com/pzy4447/p/4710539.html
     * window中preference的<key,value>存储在注册表中
     * linux下存储在文件系统中
     *
     * @throws BackingStoreException
     */
    public static void preferencesTest() throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(Chapter18_IO.class);
        preferences.put("name", "zhang");
        preferences.putInt("age", 24);
        preferences.putBoolean("isBoy", true);
        int usageCount = preferences.getInt("usageCount", 0);
        usageCount++;
        preferences.putInt("usageCount", usageCount);
        for (String key : preferences.keys()) {
            System.out.println(key + " --> " + preferences.get(key, null));
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, BackingStoreException {
//        fileTest();
//        serializableTest();
        preferencesTest();
    }
}