package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class HighlightElement extends BasePage {
	PracticePage practicePage;

	@Test
	public void highlight() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToCRM();
		practicePage.login();
	}

}
