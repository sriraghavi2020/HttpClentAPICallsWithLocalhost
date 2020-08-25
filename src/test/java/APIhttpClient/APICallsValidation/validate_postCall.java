package APIhttpClient.APICallsValidation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import APIhttpClient.APICallsForValidation.postCall;
import APIhttpClient.PayLoad.payLoad;
import APIhttpClient.TestBase.BaseClass;

public class validate_postCall extends BaseClass{
	
	String url;
	postCall postcall;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		url= initialization("getURLEmployee");
	}
	
	@Test
	public void postCall() throws JsonIOException, IOException {
		postcall = new postCall();
		
		//Header
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Connection", "keep-alive");
		header.put("Content-Type", "application/json");	//need to pass the header application/json to store the data to the server or else only the id will be created
		
		//payLoad
		//payLoad with GSON
		payLoad payload = new payLoad("Rian", "Berith", 504, 119, 201);
		Gson gson = new Gson();
		FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\java\\APIhttpClient\\PayLoad\\payload.json");
		gson.toJson(payload, writer);
		writer.close();	//need to close the file to save the data to the json.file
		String jsonAsString = gson.toJson(payload);
		System.out.println("Data to be posted: " +jsonAsString);
		
		//PostCall
		CloseableHttpResponse response = postcall.postcall(url, jsonAsString, header);
		
		//Status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		//payLoad(response) printing in console
		String jsonString= EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject jsonObject = new JSONObject(jsonString);
		System.out.println("Data that has been posted to the server(in Object Format): " +jsonObject);
		
		//Assertion of payLoad
		FileReader reader =new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\APIhttpClient\\PayLoad\\payload.json");
		payLoad responsepayLoad = gson.fromJson(reader, payLoad.class);
		reader.close();
		System.out.println("Data as a java object after conversion: "+responsepayLoad.toString());
		
		//Assertion of each data in payLoad
		System.out.println(payload.getFirstName().equals(responsepayLoad.getFirstName()));
		System.out.println(payload.getLastName().equals(responsepayLoad.getLastName()));
		
		
		
	}
	
	

}
