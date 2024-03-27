package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class HTMLUnitDriverConcept extends BasePage {

	private PracticePage practicePage;

	//WebDrier driver = new HtmlUnitDriver();
	// external should be downloaded
	@Test
	public void unitDriverTest() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToCRM();
		practicePage.login();

	}
}
