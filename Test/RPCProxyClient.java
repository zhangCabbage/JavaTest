package zhang.algorithm.JavaTest.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/29
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public class RPCProxyClient implements InvocationHandler {

    private Object obj;

    public RPCProxyClient(Object obj) {
        this.obj = obj;
    }

    /**
     * 获取被代理的对象
     *
     * @param obj
     * @return
     */
    public static Object getProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new RPCProxyClient(obj));
    }

    /**
     * 执行相关的代理逻辑, PRC的话, 就是远程方法调用的网络通信等
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        return null;
    }
}
