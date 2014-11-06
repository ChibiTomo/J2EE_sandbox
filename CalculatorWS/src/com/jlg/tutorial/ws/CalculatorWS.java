package com.jlg.tutorial.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "MyCalculatorService")
public class CalculatorWS {
	@WebMethod
	public int add(int a, int b) {
		return a + b;
	}
}
