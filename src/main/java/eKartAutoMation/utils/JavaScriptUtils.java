package eKartAutoMation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
	
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptUtils(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)this.driver;
	}
	
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	
	public WebElement scrollToElementUsingJS(By loc) {
		WebElement ele=driver.findElement(loc);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		return ele;
	}

	public void scrollDownUingJS() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
