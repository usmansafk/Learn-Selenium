import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TheDemoSiteTest {

	private ChromeDriver driver;
	private String url = "http://thedemosite.co.uk/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Prevents browser opening up repeatedly
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@After
	public void shutDown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		String uName = "test";
		String pwd = "passwordpassword2";

		driver.get(url);
		driver.findElement(By.xpath("//a[@href='addauser.php']")).click();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);

		driver.findElement(By.xpath("//input[@value='save']")).submit();

		driver.findElement(By.xpath("//a[@href='login.php']")).click();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Test Login']")).submit();

		String success = driver.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/big[1]/blockquote[1]/blockquote[1]/font[1]/center[1]/b[1]"))
				.getText();
		if (!success.equals("**Successful Login**")) {
			fail("Unsuccessful Login");
		}

	}

}
