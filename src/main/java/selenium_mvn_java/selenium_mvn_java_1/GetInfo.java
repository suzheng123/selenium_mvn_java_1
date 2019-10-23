package selenium_mvn_java.selenium_mvn_java_1;

import java.io.*;
import java.util.*;

public class GetInfo {

    public static Map<String, String> generateMap(String filePath ) throws IOException {

        Map<String, String> map = new HashMap<String, String>();
        
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String lines;

        while ((lines = br.readLine()) != null) {
            String[] element_xpath = lines.split("=", 2);
            if (element_xpath.length > 1) {
                String key = element_xpath[0];
                String value = element_xpath[1];
                map.put(key, value);
            } 
        }
        return map;
    }
    
    public static List<String> getPairList (String account_filePath) throws IOException {
    	List<String> account_info_list = new ArrayList<>();
    	
    	File file = new File(account_filePath);
    	
    	BufferedReader br = new BufferedReader(new FileReader(file));

        String lines;
        while ((lines = br.readLine()) != null) {
        	String[] account_lines = lines.split("=", 2);
            if (account_lines.length > 1) {
            	String account_name = account_lines[0];
            	String account_pwd = account_lines[1];
            	account_info_list.add(account_name);
            	account_info_list.add(account_pwd);
            }
        }    	
    	return account_info_list;
//    	return [id,pwd]    	
    }
    
//    public static List<Map<String, String>> getAccount (String account_filePath) throws IOException {
//    	Map<String, String> map = new HashMap<String, String>();
//    	List<Map<String, String>> account_list = new ArrayList<>();
//    	File file = new File(account_filePath);
//    	
//    	BufferedReader br = new BufferedReader(new FileReader(file));
//
//        String lines;
//        while ((lines = br.readLine()) != null) {
//            String[] element_xpath = lines.split("=", 2);
//            if (element_xpath.length > 1) {
//                String key = element_xpath[0];
//                String value = element_xpath[1];
//                map.put(key, value);
//                account_list.add(map);
//            } 
//        }      
//		return account_list;
//		return [ { id : pwd } ]   	
//    }
} 