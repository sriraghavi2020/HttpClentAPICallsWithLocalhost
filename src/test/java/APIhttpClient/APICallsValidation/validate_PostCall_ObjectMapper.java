package APIhttpClient.APICallsValidation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import APIhttpClient.APICallsForValidation.postCall;
import APIhttpClient.PayLoad.payLoad;
import APIhttpClient.TestBase.BaseClass;

public class validate_PostCall_ObjectMapper extends BaseClass{
	
	String url;
	postCall postcall;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		url= initialization("getURLEmployee");
	}
	
	@Test
	public void validatePostCallJackson() throws JsonGenerationException, JsonMappingException, IOException {
		
		postcall = new postCall();
		
		//Header
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Connection", "keep-alive");
		header.put("Content-Type", "application/json");
		
		//PayLoad
		//PayLoad with Jackson
		ObjectMapper mapper = new ObjectMapper();
		payLoad payload = new payLoad("Madh", "Sharki", 500, 118, 203);
		// Converting java object to JSON----> moving the above data to json file
		mapper.writeValue(new File(
			System.getProperty("user.dir")+"\\src\\main\\java\\APIhttpClient\\PayLoad\\payload.json"),
				payload);

		// Converting *java Object to JsonString
		String payloadAsString = mapper.writeValueAsString(payload);
		System.out.println("PayLoad is " + payloadAsString);

		// Hitting PostRequest
		
		//*response
		response = postcall.postcall(url, payloadAsString, header);
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code is: "+statusCode);
		
		//payLoad(response) printing in console
		String jsonString= EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println("Response as String:		"+jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		System.out.println("Data that has been posted to the server(in Object Format): " +jsonObject);
		
		payLoad reponsepayload = mapper.readValue(jsonString, payLoad.class);
		System.out.println(reponsepayload);
		
		//Assertion of the response
		System.out.println(payload.getFirstName().equals(reponsepayload.getFirstName()));
		System.out.println(payload.getFirstName().equals(reponsepayload.getLastName()));
		
	}

}
