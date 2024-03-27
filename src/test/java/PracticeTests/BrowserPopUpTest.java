package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class BrowserPopUpTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void browserPopUp() {
		practicePage = getPracticePage();
		practicePage.navigateToHYR();
		practicePage.getWindowHandles();

	}

}
