package tests;

import org.testng.annotations.Test;

public class InvocationCountTest {
	@Test(invocationCount = 10)
	public void sum() {
		int a = 10;
		int b = 20;
		System.out.println(a + b);
	}

	@Test(invocationTimeOut = 2000, expectedExceptions = NumberFormatException.class)
	public void infinteloopTest() {
		int i = 1;
		while (i == 1) {
			System.out.println(i);
		}
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}

}
