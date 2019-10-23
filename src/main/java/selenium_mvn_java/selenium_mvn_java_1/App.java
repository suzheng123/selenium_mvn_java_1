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
	
	public static List<String> getPairList( String filePath ) throws IOException {
		List<String> pairList = GetInfo.getPairList(filePath);
		return pairList;
	}
	
	public static void goToPage (String page_name_xpath) {
		clickBtn(page_name_xpath);
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

	public static void clickBtn( String btn_xpath) {
		List<String> btn_xpath_list = new ArrayList<>();
		btn_xpath_list.add(btn_xpath);
		List<WebElement> btn_element = locateElement(btn_xpath_list);
		btn_element.get(0).click();
	}
	
	public static void logIn(List<String> account_info_list,String user_path, String pwd_path, String login_btn_path) throws IOException {		

		//fill in log-in info
		List<String> logInElement = new ArrayList<>();
		logInElement.add(user_path);
		logInElement.add(pwd_path);
		List<WebElement> logIn_fields = locateElement(logInElement);
		sendKeys(logIn_fields,account_info_list);
		
		//click log_in subimit btn
		clickBtn(login_btn_path);
	}
	

    public static void main( String[] args ) throws IOException {		
//    	Map<String, String> account_map = readFile("src/main/java/files/account_info");
    	List<String> account_info_list = getPairList("src/main/java/files/account_info");
    	Map<String, String> map = readFile("src/main/java/files/web_info");
		driver = openBrowser (map.get("baseUrl"));
		
		goToPage(map.get("login_page"));
		logIn(account_info_list, map.get("user_name"), map.get("pwd"),map.get("login_btn"));
		
    }
}
