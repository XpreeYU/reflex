package jdkProxy.target;

import jdkProxy.BookFacade;

public class BookFacadeImp implements BookFacade {

	@Override
	public void addBook() {
		System.out.println("添加图书!");
	}

}
