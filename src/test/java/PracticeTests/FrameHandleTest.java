package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class FrameHandleTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void frameHandle() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToCRM();
		practicePage.login();
		Thread.sleep(3000);
		practicePage.clickContacts();
		Thread.sleep(3000);

	}
}
