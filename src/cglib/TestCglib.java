package cglib;

import cglib.proxy.BookFacadeCglib;

/**
 * 测试Cglib动态代理
 * @title TestCglib
 *
 * @author yujiansong
 * @date 2016年9月5日
 */
public class TestCglib {

	public static void main(String[] args) {
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
		bookCglib.addBook();
	}
}
