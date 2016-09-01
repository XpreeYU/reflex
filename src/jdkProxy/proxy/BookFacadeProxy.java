package jdkProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理类
 * @author yujiansong
 * @since 20160831
 */
public class BookFacadeProxy implements InvocationHandler {
	private Object target;
	
	/*
	 *绑定委托类返回代理类 
	 */
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);//要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
	}
	
	//调用方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		//调用方法前
		System.out.println("执行方法前");
		//执行方法
		result = method.invoke(target, args);
		//调用方法后
		System.out.println("执行方法后");
		return result;
	}

}
