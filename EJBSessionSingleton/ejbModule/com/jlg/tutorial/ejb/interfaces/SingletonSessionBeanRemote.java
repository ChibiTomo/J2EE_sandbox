package com.jlg.tutorial.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface SingletonSessionBeanRemote {
	String getMessage();
}
