package APIhttpClient.TestAPICalls;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import APIhttpClient.APICalls.API_deleteCAll;
import APIhttpClient.TestBase.BaseClass;

public class testAPI_deleteCall extends BaseClass{
	
	String url;
	String IdtoDelete;
	
	API_deleteCAll deletecall;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp(){
		url = initialization("getURLdata");
		
		
	}
	@Test
	public void testDeleteCall() throws ClientProtocolException, IOException {
		deletecall = new API_deleteCAll();
		IdtoDelete = "/22";	//id--> give the id number of the data to be deleted 
		String uri = url+IdtoDelete;
		deletecall.deleteCall(uri);
	}
	
	@Test
	public void testDeleteCallId4_13() throws ClientProtocolException, IOException {
		deletecall = new API_deleteCAll();
		for(int i = 4; i<=13; i++) {
		IdtoDelete = "/"+i;
		String uri = url+IdtoDelete;
		deletecall.deleteCall(uri);
		}
	}
	@Test
	public void testDeleteCallId1516() throws ClientProtocolException, IOException {
		deletecall = new API_deleteCAll();
		for(int i = 15; i<=16; i++) {
		IdtoDelete = "/"+i;
		String uri = url+IdtoDelete;
		deletecall.deleteCall(uri);
		}
	}

}
