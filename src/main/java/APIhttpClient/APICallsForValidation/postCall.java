package APIhttpClient.APICallsForValidation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class postCall {
	public CloseableHttpResponse postcall(String url,String payLoad, HashMap<String, String> headermap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient HttpLink = HttpClients.createDefault();

		// 2.Http Post Request
		HttpPost postURL = new HttpPost(url);
		
		//payloadAsString
		postURL.setEntity(new StringEntity(payLoad));

		// Header information
		for (Map.Entry<String, String> entry : headermap.entrySet()) {
			postURL.addHeader(entry.getKey(), entry.getValue());
		}

		// 3. Hit the post request
		CloseableHttpResponse response = HttpLink.execute(postURL);
		return response;


	}

}
