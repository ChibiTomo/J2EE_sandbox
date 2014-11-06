package com.jlg.tutorial.ws.client;

import com.jlg.tutorial.ws.CalculatorWS;
import com.jlg.tutorial.ws.MyCalculatorService;

public class CalculatorWSClient {
	public static void main(String[] args) {
		MyCalculatorService service = new MyCalculatorService();

		CalculatorWS calc = service.getCalculatorWSPort();

		System.out.println("3+2=" + calc.add(3, 2));
	}
}
// http://localhost:8080/CalculatorWS/MyCalculatorService?wsdl
// http://Yannis-HP:8080/CalculatorWS/MyCalculatorService?wsdl
