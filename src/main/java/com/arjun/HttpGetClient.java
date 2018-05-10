package com.arjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpGetClient {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		System.out.println("Starting");
		String url = "https://<userid>:<pass>@<hostname>:443/kylin/api/cubes";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		
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
}
