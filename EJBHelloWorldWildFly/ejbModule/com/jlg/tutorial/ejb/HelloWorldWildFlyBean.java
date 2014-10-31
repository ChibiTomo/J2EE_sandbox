package com.jlg.tutorial.ejb;

import javax.ejb.Stateless;

import com.jlg.tutorial.ejb.interfaces.HelloWorldWildFlyBeanRemote;

@Stateless
public class HelloWorldWildFlyBean implements HelloWorldWildFlyBeanRemote {

    @Override
    public String getMessage() {
        return "Hello World!";
    }

}