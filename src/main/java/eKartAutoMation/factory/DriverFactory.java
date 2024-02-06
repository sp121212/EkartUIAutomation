package eKartAutoMation.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import eKartAutoMation.exception.AppException;

public class DriverFactory {

	public WebDriver driver = null;
	public Properties prop = null;

	public WebDriver initDriver() {

		String browser = prop.getProperty("browser"); // "chrome";
		System.out.println(browser);

		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new AppException("Invalid browser name selected: " + browser);
		}

		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}

	public Properties initProp(String key, String value) {
		prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(new File("./src/test/resources/config.properties"));
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		prop.setProperty(key, value);

		return prop;

	}

}
