package PracticeTests;

import org.testng.annotations.Test;

import com.common.pages.PracticePage;
import com.common.utils.BasePage;

public class CalendarTest extends BasePage {
	private PracticePage practicePage;

	@Test
	public void calendarTest() throws Throwable {
		practicePage = getPracticePage();
		practicePage.navigateToCRM();
		practicePage.login();
		String date = "31-September-2024";
		practicePage.calendarSearch(date);

	}
}