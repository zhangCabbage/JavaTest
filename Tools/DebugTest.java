package zhang.algorithm.JavaTest.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/13
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class DebugTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {
            InheritClass test = new InheritClass();
        } catch (AException e) {
            e.printStackTrace();
        }


        String s = "java a.\nJava b.\nJAVA c.";
        Matcher matcher = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE).matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        Exception e = new Exception();
        System.out.println(e instanceof AException);
        System.out.println(AException.class.isInstance(e));

        AException ex = new AException();
        System.out.println(ex instanceof Exception);
        System.out.println(Exception.class.isInstance(ex));
//        AException.class.isAssignableFrom()

        System.out.println("--------------");
        Class c = String.class;
        System.out.println(c.isInstance(""));
        System.out.println(c.getSimpleName());

        List<? super AException> list = new ArrayList<AException>();
    }
}

class AException extends Exception {
}

class BException extends Exception {
}

class InheritClass {
    public InheritClass() throws AException {

    }

    public void event() throws AException {

    }
}

interface InterfaceClass {
    public void event() throws BException;
}

class MyList<T> {
    T t;

    public MyList() {
    }

    public MyList(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class MyList2<T> {
    Object[] objs;

    public MyList2(int size) {
        objs = new Object[size];
    }

    public void set(T t) {
        objs[0] = t;
    }

    public T get() {
        return (T) objs[0];
    }
}

class Fa <T extends Fa<T>>{

}

class Sub extends Fa{

}