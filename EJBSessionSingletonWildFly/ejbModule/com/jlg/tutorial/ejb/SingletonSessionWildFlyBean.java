package com.jlg.tutorial.ejb;

import javax.ejb.Singleton;

import com.jlg.tutorial.ejb.interfaces.SingletonSessionWildFlyBeanRemote;

@Singleton
public class SingletonSessionWildFlyBean implements SingletonSessionWildFlyBeanRemote {
	private static int counter = 0;
	private int id;
	private int a = 0;

	public SingletonSessionWildFlyBean() {
		counter++;
		id = counter;
	}

	@Override
	public String getMessage() {
		a++;
		return "a=" + a + ", counter=" + counter + ", id=" + id;
	}

}
