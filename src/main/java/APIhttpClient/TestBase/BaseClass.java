package APIhttpClient.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public static int response_status_code_200 =200;		//OK
	public static int response_status_code_201 =201;		//created
	public static int response_status_code_400 =400;
	public static int response_status_code_404 =404;
	public static int response_status_code_500 =500;
	
	String projDir= System.getProperty("user.dir");
	public static Properties prop;
	
	
//	public BaseClass() {
//		
//		try {
//			Properties prop = new Properties();
//			FileInputStream file = new FileInputStream(projDir+"\\src\\main\\java\\APIhttpClient\\Utils\\configuration.properties");
//			prop.load(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//	}
	public static  String initialization(String config)  {
		String propField= "";
		
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\APIhttpClient\\Utils\\configuration.properties");
			prop.load(file);
			propField = prop.getProperty(config);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propField;
	}

}
