package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoUserPage {
	
	@FindBy(name="username")
	private WebElement uName; 
	
	@FindBy(name="password")
	private WebElement pWord;
	
	public void createUser(String username, String password) {
		uName.sendKeys(username);
		pWord.sendKeys(password);
		pWord.submit();
	}

	public WebElement getuName() {
		return uName;
	}

	public void setuName(WebElement uName) {
		this.uName = uName;
	}

	public WebElement getpWord() {
		return pWord;
	}

	public void setpWord(WebElement pWord) {
		this.pWord = pWord;
	} 
	
	

}