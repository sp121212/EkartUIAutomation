package eKartAutoMation.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import eKartAutoMation.exception.AppException;

public class DriverFactory {

	public WebDriver driver = null;
	public Properties prop = null;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	OptionsManager optionsManager;

	public WebDriver initDriver(Properties prop) {

		String browser = prop.getProperty("browser");
		System.out.println("BROWSER NAME: " + browser);
		optionsManager = new OptionsManager(prop);

		try {
			switch (browser.toLowerCase().trim()) {
			case "chrome":
				if (Boolean.parseBoolean(prop.getProperty("remote")) == true) {
					initRemoteDriver(browser);
				} else {
					tlDriver.set(new ChromeDriver());
				}
				
				System.out.println(browser + " :browser is launched.");
				break;

			case "firefox":
				System.out.println("ENV1111:  "+prop.getProperty("remote"));
				if (Boolean.parseBoolean(prop.getProperty("remote")) == true) {
					initRemoteDriver(browser);
				} else {
					tlDriver.set(new FirefoxDriver());
				}
				
				System.out.println(browser + " :browser is launched.");
				break;

			case "edge":
				if (Boolean.parseBoolean(prop.getProperty("remote")) == true) {
					initRemoteDriver(browser);
				} else {
					tlDriver.set(new EdgeDriver());
				}
				System.out.println(browser + " :browser is launched.");
				break;
			
			default:
				System.out.println(browser + " :browser is unabled to launched. *** ERROR *** ");
				throw new AppException("Invalid browser name selected: " + browser);
			}

			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			System.out.println(prop.getProperty("url") + " :: application login page is opened.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDriver();
	}

	private void initRemoteDriver(String browser) {
		System.out.println("Running test on grid with browser: " + browser);
		try {
			switch (browser.toLowerCase().trim()) {
			case "chrome":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("hub_url")), optionsManager.getChromeOptions()));
				break;

			case "firefox":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("hub_url")), optionsManager.getFirefoxOptions()));
				break;

			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hub_url")), optionsManager.getEdgeOptions()));
				break;
				
			default:
				System.out.println("Browser name is not valid: " + browser);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	static int count = 0;

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public void quitDriver() {
		getDriver().quit();
	}

	public Properties initProp() {
		prop = new Properties();
		InputStream input = null;
		String env = System.getProperty("env"); // QA OR STAGING OR PROD
		System.out.println("ENV NAME: " + env);
		try {
			if (env == null) {
				input = new FileInputStream(new File("./src/test/resources/config/qa-config.properties"));
			} else if (env.toLowerCase().trim().equals("stage")) {
				input = new FileInputStream(new File("./src/test/resources/config/stage-config.properties"));
			} else if (env.toLowerCase().trim().equals("prod")) {
				input = new FileInputStream(new File("./src/test/resources/config/prod-config.properties"));
			} else if (env.toLowerCase().trim().equals("qa")) {
				input = new FileInputStream(new File("./src/test/resources/config/qa-config.properties"));
			} else {
				throw new AppException("Wrong env is passed. " + env);
			}
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * Take screenshot
	 * 
	 * @param methodName
	 * @return
	 */
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\" + methodName + "_" + System.currentTimeMillis()
				+ ".png";
		System.out.println("path>>>>  " + path);
		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
