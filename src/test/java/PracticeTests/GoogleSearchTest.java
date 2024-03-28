package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class GoogleSearchTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void googleSearchTest() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToGoogle();
		practicePage.googleSearch();

	}

}