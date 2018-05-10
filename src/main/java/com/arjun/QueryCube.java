package com.arjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class QueryCube {
	public static void main(String[] args) {

		try {

			URL url = new URL("https://<username>:<pass>@<hostname>:443/kylin/api/query");
			String json = "{\"sql\":  \" SELECT * FROM KYLIN_ACCOUNT LIMIT 1 \"}";
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			String userpass = "usename" + ":" + "Password";
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
			
			conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            
            String userPassword = "ADMIN" + ":" + "Pass0013@";
            String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
            
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("Authorization", "Basic " + encoding);
            uc.connect();

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
			
			System.out.println("Printing Data");
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
