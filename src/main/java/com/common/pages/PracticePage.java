package com.common.pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.common.utils.BasePage;

public class PracticePage extends BasePage {
	private static WebDriver driver;
	@FindBy(how = How.XPATH, using = "//em[@id='eyeicon']//following-sibling::input[@type='submit']")
	private WebElement signinBtn;

	@FindBy(how = How.XPATH, using = "//a[@class='signin']")
	private WebElement loginBtn;

	@FindBy(how = How.XPATH, using = "//form[@action='myform.cgi']//child::input[@type='file']")
	private WebElement fileBtn;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder, 'Username')]")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder, 'Password')]")
	private WebElement password;
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Username')]//following-sibling::div//input[@type='submit']")
	private WebElement loginCRM;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contacts')]")
	private WebElement contacts;
	@FindBy(how = How.XPATH, using = "//div[text()='Add-ons']")
	private WebElement addOn;
	@FindBy(how = How.XPATH, using = "//div[text()='SpiceMax' and @class ='css-76zvg2 r-homxoj r-ubezar']")
	private WebElement mouseHoverOption;
	@FindBy(how = How.XPATH, using = "//div[@id='draggable']//child::p")
	private WebElement dragBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='droppable']//child::p")
	private WebElement dropBtn;
	@FindBy(how = How.XPATH, using = "//div//child::button[@id='newWindowBtn']")
	private WebElement popWindow;
	@FindBy(how = How.XPATH, using = "//textarea[@id='APjFqb']")
	private static WebElement googleSearchBtn;
	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']//li")
	private static List<WebElement> searchSuggestions;
	@FindBy(how = How.XPATH, using = "//div[@id='crmcalendar']//descendant::select[@name='slctMonth']")
	private static WebElement calendarMonth;
	@FindBy(how = How.XPATH, using = "//div[@id='crmcalendar']//descendant::select[@name='slctYear']")
	private static WebElement calendarYear;

	public PracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToReddif() {
		driver.get("https://mail.rediff.com/");
	}

	public void navigateToGoogle() {
		driver.get("https://google.com/");
	}

	public void navigateToFile() {
		driver.get("https://html.com/input-type-file/");
	}

	public void navigateToCRM() {
		driver.get("https://classic.freecrm.com/");
		System.out.println(driver.getTitle());
	}

	public void navigateToSpiceJet() {
		driver.get("https://www.spicejet.com/");
	}

	public void navigateToDragAndDrop() {
		driver.get("https://jqueryui.com/droppable/");
	}

	public void navigateToHYR() {
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	}

	public void switchToPopUp() {
		clickBtn(loginBtn);
		clickBtn(signinBtn);
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println(alertMsg);
		if (alertMsg.equals("Please enter a valid user name"))
			System.out.println("correct Alert");

		else
			System.out.println("Incorrect Alert");
		alert.accept();
	}

	public void switchToFilePopUp() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 700);");
		fileBtn.sendKeys("C:\\Users\\Manasa\\Pictures\\Screenshots\\Screenshot (1).png");
		Thread.sleep(2000);
	}

	public void login() throws Throwable {
		userName.sendKeys("rakshitha");
		password.sendKeys("Test@1");
		drawBorder(loginCRM);
		flash(loginCRM);
		//generateAlert("alert from page");
		loginCRM.click();
		System.out.println(driver.getTitle());

	}

	public void clickContacts() {
		driver.switchTo().frame("mainpanel");
		clickBtn(contacts);

	}

	public void clickBtn(WebElement ele) {
		ele.click();
	}

	public void mouseHoverable() throws Throwable {
		Actions action = new Actions(driver);
		action.moveToElement(addOn).build().perform();
		Thread.sleep(3000);
		action.moveToElement(mouseHoverOption).click();

	}

	public void dragAndDrop() {
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		action.clickAndHold(dragBtn).moveToElement(dropBtn).release().build().perform();

	}

	public void naviagteBack() {
		driver.navigate().back();
	}

	public void naviagteFoward() {
		driver.navigate().forward();
	}

	public void takeScreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Manasa\\Downloads\\photo.png"));
	}

	public void getWindowHandles() {
		clickBtn(popWindow);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		System.out.println("ParentWindowHandle : " + parentWindow);
		String childWindow = it.next();
		System.out.println("childWindowHandle : " + childWindow);
		driver.switchTo().window(childWindow);
		System.out.println("childwindowtile:" + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("Parentwindowtile:" + driver.getTitle());

	}

	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolour = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changecolour("rgb(0,200,0)", element);
			changecolour(bgcolour, element);
		}

	}

	public void changecolour(String colour, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + colour + "'", element);
	}

	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}

	public void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public void clickByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public void refreshBrowser() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		return innerText;
	}

	public static void scrollDownByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
	}

	public static void scrollToViewByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments.scrollIntoView(true);", element);
	}

	public static void googleSearch() throws Throwable {
		googleSearchBtn.sendKeys("Java");
		List<WebElement> list = searchSuggestions;
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("javascript")) {
				list.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}

	}

	public static WebElement findElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void calendarSearch(String date) {
		driver.switchTo().frame("mainpanel");

		String dateArray[] = date.split("-");
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];
		Select select = new Select(calendarMonth);
		select.selectByVisibleText(month);
		Select select1 = new Select(calendarYear);
		select1.selectByVisibleText(year);
		final int totalWeekDays = 7;
		String dayValue = null;
		boolean flag = false;
		for (int row = 2; row <= 7; row++) {
			for (int column = 1; column <= totalWeekDays; column++) {
				try {
					dayValue = findElementByXPath("//div[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr["
							+ row + "]/td[" + column + "]").getText();
				} catch (Exception e) {
					System.out.println("Enter a correct date");
					flag = true;
					break;
				}
				System.out.println(dayValue);
				if (dayValue.equals(day)) {
					flag = true;
					findElementByXPath("//div[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[" + row + "]/td["
							+ column + "]").click();
					break;
				}
			}
			if (flag)
				break;
		}

	}
}
