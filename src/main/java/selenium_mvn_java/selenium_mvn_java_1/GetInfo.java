package selenium_mvn_java.selenium_mvn_java_1;

import java.io.*;
import java.util.*;

public class GetInfo {

    public static Map<String, String> generateMap(String filePath ) throws IOException {

        Map<String, String> map = new HashMap<String, String>();

//        File file = new File("src/main/java/files/web_info");
        
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String lines;

        while ((lines = br.readLine()) != null) {
            String[] element_xpath = lines.split("=", 2);
            if (element_xpath.length >= 2) {
                String key = element_xpath[0];
                String value = element_xpath[1];
                map.put(key, value);
            } 
        }
        return map;
    }
} 