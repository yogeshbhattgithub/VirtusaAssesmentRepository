package com.yogesh.assesment.ExchangeRateAPI.pojoClass;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ExchangeRates {

	final public static String baseURL="https://api.ratesapi.io/api/";
	public static String base;
	public static String symbol;
	public static String date;
	
    public static String getResponse(String url) {
    	try {
    		
    	
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	HttpGet httpGet=new HttpGet(url);
    	HttpResponse httpResponse = httpclient.execute(httpGet);
    	int status=httpResponse.getStatusLine().getStatusCode();
    	if(status >= 200 && status <=400)
    	{
    		HttpEntity entity = httpResponse.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            return content;

    	}
    	else 
    	{
    		return "unavailable"+status;
    	}
    	     	}
    	
    	catch(IOException e) {
    		return e.getMessage();
    	}
    	
    	catch(Exception e) {
    		return e.getMessage();
    	}
    	
}
	


}
