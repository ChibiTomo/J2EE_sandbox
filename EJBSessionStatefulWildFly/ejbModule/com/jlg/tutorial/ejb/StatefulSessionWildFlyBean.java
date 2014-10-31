package com.jlg.tutorial.ejb;

import javax.ejb.Stateful;

import com.jlg.tutorial.ejb.interfaces.StatefulSessionWildFlyBeanRemote;

@Stateful
public class StatefulSessionWildFlyBean implements StatefulSessionWildFlyBeanRemote {
	private static int counter = 0;
	private int id;
	private int a = 0;

	public StatefulSessionWildFlyBean() {
		counter++;
		id = counter;
	}

	@Override
	public String getMessage() {
		a++;
		return "a=" + a + ", counter=" + counter + ", id=" + id;
	}

}
