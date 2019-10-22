package selenium_mvn_java.selenium_mvn_java_1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App 
{
	public static WebDriver driver = null;
	
	public static WebDriver openBrowser( String baseUrl) {
		System.setProperty("webdriver.gecko.driver", "/Users/JacZh/Desktop/resources/selenium_java/webdrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		return driver;
	}
	
	public static Map<String, String> readFile( String filePath ) throws IOException{
		Map<String, String> map = GetInfo.generateMap(filePath);
		return map;
	}
	
	public static List<WebElement> locateElement ( List<String> elements) {

		List<WebElement> elementFields = new ArrayList<>();
		for (int i = 0; i<elements.size(); i++) {
			By xpath = By.xpath(elements.get(i));
			List<WebElement> webElements = driver.findElements(xpath);
			elementFields.addAll(webElements);
		}
		return elementFields;
	}

	public static void sendKeys( List<WebElement> fields, List<String> txtToSend) {
		for (int i = 0;i<fields.size();i++){
			fields.get(i).sendKeys(txtToSend.get(i));
		}
	}

	public static void clickBtn( String btn_path) {
		
	}
	
	public static void logIn(List<String> account_info,String user_path, String pwd_path) throws IOException {
		//fill in log-in info
		List<String> logInElement = new ArrayList<>();
		logInElement.add(user_path);
		logInElement.add(pwd_path);
		List<WebElement> logIn_fields = locateElement(logInElement);
		sendKeys(logIn_fields,account_info);

	}
	
    public static void main( String[] args ) throws IOException {
//		Map<String, String> account = readFile("src/main/java/files/account_info");
//		String[] account = ["admin","12345"];
				
    	Map<String, String> map = readFile("src/main/java/files/web_info");
    	List<String> account = Arrays.asList("admin", "12345");
		driver = openBrowser (map.get("baseUrl"));
		
		List<String> x = new ArrayList<>();
		String loginPage = map.get("login_page");
		x.add(loginPage);
		List<WebElement> elementPath = locateElement(x);
		elementPath.get(0).click();
		
		logIn(account, map.get("user_name"), map.get("pwd"));
    }
}
