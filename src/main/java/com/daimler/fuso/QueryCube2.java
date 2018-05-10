package com.daimler.fuso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class QueryCube2 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		System.out.println("Starting");
		String url = "https://<hostname>:443/kylin/api/query";
		String json = "{\"sql\":  \" SELECT * FROM KYLIN_SALES LIMIT 1 \" , \"project\": \"learn_kylin\"}";

			
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		request.addHeader("Authorization", "Basic " + getBasicAuthenticationEncoding());
		
		
		//List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		//pairs.add(new BasicNameValuePair("sql", "SELECT * FROM KYLIN_ACCOUNT LIMIT 1"));
		//request.setEntity(new UrlEncodedFormEntity(pairs ));
	
		request.setHeader("Content-type", "application/json");
		StringEntity stringEntity = new StringEntity(json);
		request.getRequestLine();
		request.setEntity(stringEntity);
		
		HttpResponse response = client.execute(request);
			
		
		// Get the response
		System.out.println("Getting response");
		BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
		    System.out.println(line);
		}
		
		
	}
	
	public static String getBasicAuthenticationEncoding() {

        String userPassword = "ADMIN" + ":" + "Pass0013@";
        return new String(Base64.encodeBase64(userPassword.getBytes()));
    }
	
}
