package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class MouseMovementTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void mouseMovement() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToSpiceJet();
		practicePage.mouseHoverable();
		Thread.sleep(3000);
	}
}
