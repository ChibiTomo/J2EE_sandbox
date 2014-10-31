package com.jlg.tutorial.ejb;

import javax.ejb.Stateless;

import com.jlg.tutorial.ejb.interfaces.StatelessSessionWildFlyBeanRemote;

@Stateless
public class StatelessSessionWildFlyBean implements StatelessSessionWildFlyBeanRemote {
	private static int counter = 0;
	private int id;
	private int a = 0;

	public StatelessSessionWildFlyBean() {
		counter++;
		id = counter;
	}

	@Override
	public String getMessage() {
		try {
			a = 0;
			Thread.sleep(5000);
			a = 1;
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "a=" + a + ", counter=" + counter + ", id=" + id;
	}

}
