package zhang.algorithm.JavaTest.ThinkingJava;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/5
 * Time: 下午8:39
 * To change this template use File | Settings | File Templates.
 * <p>
 * 关于class对象的getName方法: getName() | getCanonicalName() | getSimpleName()
 * 以下是简单比较, testName是包名
 * Name.class.getCanonicalName(): testName.Name
 * Name.class.getName():          testName.Name
 * Name.class.getSimpleName():    Name
 * <p>
 * Name.Inner.class.getCanonicalName(): testName.Name.Inner
 * Name.Inner.class.getName():          testName.Name$Inner
 * Name.Inner.class.getSimpleName():    Inner
 * <p>
 * args.getClass().getCanonicalName(): Java.lang.String[]
 * args.getClass().getName():          [Ljava.lang.String;
 * args.getClass().getSimpleName():    String[]
 */
public class Chapter20_Annotation {

    public static void main(String[] args) {
        Chapter20_Annotation test = new Chapter20_Annotation();
//        System.out.println(Modifier.isPublic(Integer.class.getMethods()[0].getModifiers()));
    }
}

