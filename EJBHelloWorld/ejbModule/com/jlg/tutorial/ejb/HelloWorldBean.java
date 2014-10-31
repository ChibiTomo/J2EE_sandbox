package com.jlg.tutorial.ejb;

import javax.ejb.Stateless;

import com.jlg.tutorial.ejb.interfaces.HelloWorldBeanRemote;

@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {

    @Override
    public String getMessage() {
        return "Hello World!";
    }

}