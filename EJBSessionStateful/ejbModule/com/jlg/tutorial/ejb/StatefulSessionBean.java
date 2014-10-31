package com.jlg.tutorial.ejb;

import javax.ejb.Stateful;

import com.jlg.tutorial.ejb.interfaces.StatefulSessionBeanRemote;

@Stateful
public class StatefulSessionBean implements StatefulSessionBeanRemote {
	private static int counter = 0;
	private int id;
	private int a = 0;

	public StatefulSessionBean() {
		counter++;
		id = counter;
	}

	@Override
	public String getMessage() {
		a++;
		return "a=" + a + ", counter=" + counter + ", id=" + id;
	}

}
