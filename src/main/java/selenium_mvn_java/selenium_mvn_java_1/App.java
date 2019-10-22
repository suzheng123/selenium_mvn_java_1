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
	
	public static WebDriver openBrowser( String baseUrl ) {
		System.setProperty("webdriver.gecko.driver", "/Users/JacZh/Desktop/resources/selenium_java/webdrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		return driver;
	}
	
	public static Map<String, String> readFile( String filePath ) throws IOException{
		Map<String, String> map = GetInfo.generateMap(filePath);
		return map;
	}
	
	public static void goToPage (String page_name_path) {
		List<String> x = new ArrayList<>();
		x.add(page_name_path);
		List<WebElement> elementPath = locateElement(x);
		clickBtn(elementPath.get(0));
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

	public static void clickBtn( WebElement btn_path) {
		btn_path.click();
	}
	
	public static void logIn(List<String> account_info,String user_path, String pwd_path, String login_btn_path) throws IOException {		
		//fill in log-in info
		List<String> logInElement = new ArrayList<>();
		logInElement.add(user_path);
		logInElement.add(pwd_path);
		List<WebElement> logIn_fields = locateElement(logInElement);
		sendKeys(logIn_fields,account_info);
		
		//click log_in subimit btn
		List<String> logInBtn = new ArrayList<>();
		logInBtn.add(login_btn_path);
		List<WebElement> log_in_btn= locateElement(logInBtn);
		clickBtn(log_in_btn.get(0));
	}
	

    public static void main( String[] args ) throws IOException {				
    	Map<String, String> map = readFile("src/main/java/files/web_info");
    	List<String> account = Arrays.asList("admin", "12345");
		driver = openBrowser (map.get("baseUrl"));
		
		goToPage(map.get("login_page"));
		logIn(account, map.get("user_name"), map.get("pwd"),map.get("login_btn"));
		
    }
}
