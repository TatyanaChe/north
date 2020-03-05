package org.ch.tan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEntryPage extends PageObject {

	public AddEntryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "id_title")
	private WebElement title;

	@FindBy(id = "id_slug")
	private WebElement slug;

	@FindBy(id = "id_text_markdown")
	private WebElement markdown;

	@FindBy(id = "id_text")
	private WebElement text;

	@FindBy(xpath = "*//*[@value='Сохранить']")
	private WebElement buttonSave;

	public AddEntryPage addTitle(String randomTitle) {
		title.sendKeys(randomTitle);
		return this;
	}

	public AddEntryPage addSlug(String randomSlug) {
		slug.clear();
		slug.sendKeys(randomSlug);
		return this;
	}

	public AddEntryPage addMarkdown(String randomMarkdown) {
		markdown.sendKeys(randomMarkdown);
		return this;
	}

	public AddEntryPage addText(String randomText) {
		text.sendKeys(randomText);
		return this;
	}

	public void buttonSave() {
		buttonSave.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
