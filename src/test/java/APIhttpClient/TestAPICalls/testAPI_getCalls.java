package APIhttpClient.TestAPICalls;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import APIhttpClient.APICalls.API_getCall;
import APIhttpClient.TestBase.BaseClass;

public class testAPI_getCalls extends BaseClass{
	
	String url;
	API_getCall getCall;
	
	public testAPI_getCalls() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		url = prop.getProperty("getURLEmployee");
		//url =initialization("getURLEmployee");
		
	}
	@Test
	public void testGetCall() throws ClientProtocolException, IOException {
		
		getCall = new API_getCall();
		getCall.getRequest(url);
	}

}
