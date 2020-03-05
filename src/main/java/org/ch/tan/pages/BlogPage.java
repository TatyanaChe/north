package org.ch.tan.pages;

import org.openqa.selenium.WebDriver;

public class BlogPage extends PageObject {

	public BlogPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyTitleIsPresent(String randomTitle) {
		return super.verifyTitleIsPresent(randomTitle);
	}

	public void open() {
		driver.get("http://igorakintev.ru/blog/");
	}
}
