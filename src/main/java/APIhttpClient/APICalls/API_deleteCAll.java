package APIhttpClient.APICalls;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class API_deleteCAll {
	
	public void deleteCall(String url) throws ClientProtocolException, IOException {
	
		CloseableHttpClient link = HttpClients.createDefault();
		
		HttpDelete httpdelete = new HttpDelete(url);
		
		CloseableHttpResponse response = link.execute(httpdelete);
		
		//Status code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code is: "+statusCode);
		
		//Response 
		
		String JsonStringResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(JsonStringResponse);
		
		
	}

	
}
