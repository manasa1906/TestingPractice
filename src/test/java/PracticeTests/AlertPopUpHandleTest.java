package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class AlertPopUpHandleTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void popUpHandle() {
		practicePage = getPracticePage();
		practicePage.navigateToReddif();
		practicePage.switchToPopUp();

	}

	@Test
	public void filePopUp() throws InterruptedException {
		practicePage = getPracticePage();
		practicePage.navigateToFile();
		practicePage.switchToFilePopUp();

	}
}
