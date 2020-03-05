package org.ch.tan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminBlogEntryPage extends PageObject {

	private static final String TITLE_LOCATOR = "*//a[text()='%s']/../../td[1]/input";

	public AdminBlogEntryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "*//a[text()=%s]/../../td[1]/input")
	private WebElement checkBox;

//	@FindBy(xpath = "*//*[@name='action']")
	@FindBy(xpath = "*//*[@value='delete_selected']")
	private WebElement dropDownAction;

	@FindBy(xpath = "*//*[@class='button']")
	private WebElement buttonRun;

	@FindBy(xpath = "*//input[@value='Да, я уверен']")
	private WebElement buttonSure;

	public AdminBlogEntryPage open() {
		driver.get("https://igorakintev.ru/admin/blog/entry/");
		return this;
	}

	public boolean verifyTitleIsPresent(String randomTitle) {
		return super.verifyTitleIsPresent(randomTitle);
	}

	public AdminBlogEntryPage checkBoxEntry(String title) {
		By locator = By.xpath(String.format(TITLE_LOCATOR, title));
		WebElement check = driver.findElement(locator);
		if (!check.isSelected()) {
			check.click();
		}
		return this;
	}

	public AdminBlogEntryPage selectAction() {
		dropDownAction.click();
		return this;

	}

	public AdminBlogEntryPage clickButtonRun() {
		buttonRun.click();
		return this;
	}

	public void clickButtonSure() {
		buttonSure.click();
	}

}
