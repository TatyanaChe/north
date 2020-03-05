package org.ch.tan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	protected boolean verifyTitleIsPresent(String randomTitle) {
		boolean result = false;
		try {
			String xpathExpression = "*//a[text()='" + randomTitle + "']";
			By locator = By.xpath(xpathExpression);

			if (driver.findElement(locator).isDisplayed()) {
				result = true;
			}
		} catch (NoSuchElementException e) {
			result = false;
		}
		return result;
	}
}
