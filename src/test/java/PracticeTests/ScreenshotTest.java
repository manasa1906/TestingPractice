package PracticeTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class ScreenshotTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void takeScreenshot() throws IOException {
		practicePage = getPracticePage();
		practicePage.navigateToSpiceJet();
		practicePage.takeScreenshot();

	}
}
