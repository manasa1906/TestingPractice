package com.common.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

	public PracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToReddif() {
		driver.get("https://mail.rediff.com/");
	}

	public void navigateToFile() {
		driver.get("https://html.com/input-type-file/");
	}

	public void navigateToCRM() {
		driver.get("https://classic.freecrm.com/");
	}

	public void navigateToSpiceJet() {
		driver.get("https://www.spicejet.com/");
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

	public void login() {
		userName.sendKeys("rakshitha");
		password.sendKeys("Test@1");
		loginCRM.click();

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
}
