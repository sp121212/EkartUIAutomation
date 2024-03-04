package eKartAutoMation.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	private Properties prop=null;
	
	
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	
	
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))== true) {
			co.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito"))== true) {
			co.addArguments("--incognito");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))== true) {
			co.setCapability("browserName", "chrome");
		}
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))== true) {
			fo.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito"))== true) {
			fo.addArguments("--incognito");
		}
	
		if(Boolean.parseBoolean(prop.getProperty("remote"))== true) {
			fo.setCapability("browserName", "firefox");
		}
		
		
		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))== true) {
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))== true) {
			eo.addArguments("--incognito");
		}
//		if(Boolean.parseBoolean(prop.getProperty("remote"))== true) {
//			eo.setCapability("browserName","edge");
//		}
		
		return eo;
	}
	
	
	

}
