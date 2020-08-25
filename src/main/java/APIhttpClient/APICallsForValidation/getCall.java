package APIhttpClient.APICallsForValidation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class getCall {
	
public CloseableHttpResponse getCallRequest(String url) throws ClientProtocolException, IOException {
	//creating link
			CloseableHttpClient clientLink = HttpClients.createDefault();
			//getting the url
			HttpGet getrequest = new HttpGet(url);
			//hitting--> .execute() 	and getting the response
			CloseableHttpResponse response =clientLink.execute(getrequest);
			return response;
}


public CloseableHttpResponse getCallRequest(String url, HashMap<String, String> header) throws ClientProtocolException, IOException {
	//creating link
			CloseableHttpClient clientLink = HttpClients.createDefault();
			//getting the url
			HttpGet getrequest = new HttpGet(url);
			
			//Adding header details
			for(Map.Entry<String, String> entry : header.entrySet()) {
				getrequest.addHeader(entry.getKey(), entry.getValue()); 
			}
			//hitting--> .execute() 	and getting the response
			CloseableHttpResponse response =clientLink.execute(getrequest);
			return response;
}
}
