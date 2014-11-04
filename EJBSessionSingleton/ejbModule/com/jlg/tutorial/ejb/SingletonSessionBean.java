package com.jlg.tutorial.ejb;

import javax.ejb.Singleton;

import com.jlg.tutorial.ejb.interfaces.SingletonSessionBeanRemote;

@Singleton
public class SingletonSessionBean implements SingletonSessionBeanRemote {
	private static int counter = 0;
	private int id;
	private int a = 0;

	public SingletonSessionBean() {
		counter++;
		id = counter;
	}

	@Override
	public String getMessage() {
		a++;
		return "a=" + a + ", counter=" + counter + ", id=" + id;
	}

}
