package APIhttpClient.APICalls;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class API_getCall {
	public void getRequest(String url) throws ClientProtocolException, IOException {
		//creating link
		CloseableHttpClient clientLink = HttpClients.createDefault();
		//getting the url
		HttpGet getrequest = new HttpGet(url);
		//hitting--> .execute() 	and getting the response
		CloseableHttpResponse response =clientLink.execute(getrequest);
		
		//status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code: "+statusCode);
		
		//Json response --> getting the response in string data format 
		String jsonString = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(jsonString);
		// converting it to JSON object format (or)Json Array format
		JSONArray json = new JSONArray(jsonString);
		
		
		//JSON response
		System.out.println("JSon response " +json);
		
		
		//getting header details
		Header[] headerArray = response.getAllHeaders();
		HashMap<String, String> headerDetails = new HashMap<String, String>();
		
		for(Header header: headerArray) {
			headerDetails.put(header.getName(), header.getValue());
		}
		System.out.println("Header details: "+headerDetails);
	}

}
