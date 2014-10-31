package com.jlg.tutorial.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {
	String getMessage();
}
