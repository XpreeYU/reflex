package cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 使用Cglib实现动态代理（）
 * @title BookFacadeCglib
 *
 * @author yujiansong
 * @date 2016年9月5日
 */
public class BookFacadeCglib implements MethodInterceptor{
	private Object target;
	

	//创建动态代理对象
	public Object getInstance(Object target){
		this.target = target;
		//创建增强对象
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(this.target.getClass());
		
		//设置回调函数
		enhancer.setCallback(this);
		//创建代理对象
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
		Object result = null;
		System.out.println("事务开始!");
		result = proxy.invoke(target, arg);
		System.out.println("事务结束!");
		
		return result;
	}

}
