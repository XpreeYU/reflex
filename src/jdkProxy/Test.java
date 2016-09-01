package jdkProxy;

import jdkProxy.proxy.BookFacadeProxy;
import jdkProxy.target.BookFacadeImp;

/**
 * 测试jdk动态代理
 * @author yujiansong
 *
 */
public class Test {

	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImp());
		bookFacade.addBook();
	}
}
