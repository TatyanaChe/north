
import org.ch.tan.common.Browser;
import org.ch.tan.common.DriverFactory;
import org.ch.tan.pages.AddEntryPage;
import org.ch.tan.pages.AdminBlogEntryPage;
import org.ch.tan.pages.AdminPage;
import org.ch.tan.pages.BlogPage;
import org.ch.tan.pages.LoginPage;
import org.ch.tan.util.RandomUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {

	private WebDriver driver;
	String randomTitle = RandomUtil.generate("Title");

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = DriverFactory.get(Browser.chrome);
		
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {

//		1) Заходит на страницу - http://igorakintev.ru/admin/ 
//		2) Заполняет имя пользователя - selenium 
//		3) Заполняет пароль - super_password 
//		4) Нажимает кнопку Войти 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open().enterLogin("selenium").enterPassword("super_password").clickEnter();

//		5) Проверяет что на новой станице присутствует заголовок - “Панель управления” 		
		AdminPage adminPage = new AdminPage(driver);
		String adminPageTitle = adminPage.getTitle();
		Assert.assertTrue("Заголовок не содержит Панель управления", adminPageTitle.contains("Панель управления"));
		
//		6) Нажимает кнопку “+ Добавить” в разделе Blog/Entries
		adminPage.addEntry();
		
//		7) Проверяет что на новой станице присутствует заголовок - “Добавить entry” 
		AddEntryPage addEntryPage = new AddEntryPage(driver);
		String addEntryPageTitle = addEntryPage.getTitle();
		Assert.assertTrue("Заголовок не содержит Добавить entry", addEntryPageTitle.contains("Добавить entry"));
//		
//		8) Заполняет поле title - случайной строкой (пример: Title43565463456) 
//		9) Заполняет поле Slug - случайной строкой (пример: Slug43565463456) 
//		10) Заполняет поле Text markdown - случайной строкой (пример: Slug43565463456) 
//		11) Заполняет поле Text - случайной строкой (пример: Slug43565463456) 
//		12) Нажимает кнопку Сохранить 
		addEntryPage.addTitle(randomTitle)
			.addSlug(RandomUtil.generate("Slug"))
			.addMarkdown(RandomUtil.generate("Markdown"))
			.addText(RandomUtil.generate("Text"))
			.buttonSave();

//		13) Переходит на страницу: http://igorakintev.ru/blog/ 
//		14) Удостоверяется что ранее созданная запись отображается на сайте	
		BlogPage blogPage = new BlogPage(driver);
		blogPage.open();
		Assert.assertTrue("Нет последней записи с заголовком " + randomTitle, blogPage.verifyTitleIsPresent(randomTitle));
		
		
//		15) Удаляет созданную запись (в админ панели)
		AdminBlogEntryPage adminBlogEntryPage = new AdminBlogEntryPage(driver);
		adminBlogEntryPage.open()
			.checkBoxEntry(randomTitle)
			.selectAction()
			.clickButtonRun()
			.clickButtonSure();
		Assert.assertFalse("Последняя запись " + randomTitle + " не удалена.", adminBlogEntryPage.verifyTitleIsPresent(randomTitle));
		Thread.sleep(3000);
	}

}
