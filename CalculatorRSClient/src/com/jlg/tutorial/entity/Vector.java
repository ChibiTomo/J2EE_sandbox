package com.jlg.tutorial.entity;

public class Vector {
	public int x = 0;
	public int y = 0;

	public Vector() {
	}

	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public static Vector valueOf(String str) {
		int x =
				Integer.parseInt(str.substring(str.indexOf('(') + 1,
						str.indexOf(',')));
		int y =
				Integer.parseInt(str.substring(str.indexOf(',') + 1,
						str.indexOf(')')));
		return new Vector(x, y);
	}
}
