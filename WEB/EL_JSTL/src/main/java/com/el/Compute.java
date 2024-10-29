package com.el;

public class Compute {
	public static int sum(String x, String y) {
		int result = Integer.parseInt(x) + Integer.parseInt(y);
		return result;
	}
	public static int sub(String x, String y) {
		int result = Integer.parseInt(x) - Integer.parseInt(y);
		return result;
	}
	public static int mul(String x, String y) {
		int result = Integer.parseInt(x) * Integer.parseInt(y);
		return result;
	}
}
