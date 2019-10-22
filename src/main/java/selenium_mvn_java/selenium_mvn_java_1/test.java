package selenium_mvn_java.selenium_mvn_java_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
	public static List<Map<String, String>> getAccount (String account_filePath) throws IOException {
		account_filePath = "src/main/java/files/";
    	Map<String, String> map = new HashMap<String, String>();
    	
    	List<Map<String, String>> account_list = new ArrayList<>();
    	File file = new File(account_filePath);
    	
    	BufferedReader br = new BufferedReader(new FileReader(file));

        String lines;
        while ((lines = br.readLine()) != null) {
            String[] element_xpath = lines.split("=", 2);
            if (element_xpath.length >= 2) {
                String key = element_xpath[0];
                String value = element_xpath[1];
                map.put(key, value);
                System.out.println(map);
            } 
        }
       
		return null;
	}
}
