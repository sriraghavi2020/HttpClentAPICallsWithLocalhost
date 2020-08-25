package APIhttpClient.APICallsValidation;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import APIhttpClient.APICallsForValidation.getCall;
import APIhttpClient.TestBase.BaseClass;
import APIhttpClient.ValidateJSONResponse.validateJSONResponse;

public class validate_getCall extends BaseClass{
	String url;


	getCall getcall;
	CloseableHttpResponse response;
	validateJSONResponse validation;

	@BeforeMethod
	public void setUp() {

		url= initialization("getURLEmployee");
	}

	@Test
	public void validateGetCall() throws ClientProtocolException, IOException {
		getcall = new getCall();
		
		HashMap<String, String> headerContent = new HashMap<String, String>();
		headerContent.put("Connection", "keep-alive");
		
		response = getcall.getCallRequest(url, headerContent);
		validation =new validateJSONResponse();
		

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code: "+statusCode);
		//Assertion for status code
		Assert.assertEquals(statusCode, response_status_code_200, "Status code is not 200");


		String jsonString = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(jsonString);
		JSONArray json = new JSONArray(jsonString);	//Converting String to JSONArray format
		System.out.println("JSon response " +json);
		//Assertion/checking the response JsonArray format
		boolean value =validation.validateResposeJSONArray(json, "Paul");
		System.out.println(value);
		//Assertion/checking the response JsonObject format as each index
		for(int i = 0; i<json.length(); i++) {
			JSONObject JObject = json.getJSONObject(i);
			System.out.println(JObject);
		}
		
		Gson gson = new Gson();	//Converting JSONString to JSONObject
		String data = gson.toJson(json);
		JSONObject obj = new JSONObject(data);
		System.out.println(obj);
		//Assertion the response as per requested sting value/array value
		String val = validation.validateResponseJSONObject(obj, "/myArrayList[10]/map/LastName");
		String val1 = validation.validateResponseJSONObject(obj, "/myArrayList[10]/map/FirstName");
		System.out.println("Last name: "+val);
		System.out.println("First name: "+val1);

		
		Header[] headerArray = response.getAllHeaders();	//getting header details
		HashMap<String, String> headerDetails = new HashMap<String, String>();

		for(Header header: headerArray) {
			headerDetails.put(header.getName(), header.getValue());
		}
		System.out.println("Header details: "+headerDetails);
		//Assertion on header details
		Assert.assertEquals(headerDetails.get("Connection"), "keep-alive");
	}

}
