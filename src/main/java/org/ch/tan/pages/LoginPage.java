package org.ch.tan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

	@FindBy(id = "id_username")
	private WebElement loginId;
	
	@FindBy(id = "id_password")
	private WebElement passwordId;
	
	@FindBy(xpath = "*//input[@value='Войти']")
	private WebElement button;


	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage open() {
		driver.get("http://igorakintev.ru/admin/");
		return this;
	}

	public LoginPage enterLogin(String login) {
		loginId.sendKeys(login);
		return this;
		
	}

	public LoginPage enterPassword(String pwd) {
		passwordId.sendKeys(pwd);
		return this;
	}

	public void clickEnter() {
		button.click();
	}

}
