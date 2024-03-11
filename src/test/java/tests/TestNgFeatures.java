package tests;

import org.testng.annotations.Test;

public class TestNgFeatures {
	@Test
	public void linkTest() {
		System.out.println("LinkTest");
		//int i = 9 / 0;
	}

	@Test(dependsOnMethods = "linkTest")
	public void homePageTest() {
		System.out.println("HomeTest");
	}

	@Test(dependsOnMethods = "homePageTest")
	public void regPageTest() {
		System.out.println("RegTest");

	}

}
