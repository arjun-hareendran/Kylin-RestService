package com.daimler.fuso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ListCubes {
	public static void main(String[] args) {

		try {

			//URL url = new URL("https://dfldevhbase01-kap.apps.azurehdinsight.net:443/kylin/api/cubes");
			URL url = new URL("https://<hostname>:443/kylin/api/cubes/kylin_sales_cube");
			
			URLConnection uc = url.openConnection();
			String userpass = "XXXX" + ":" + "XXXX";
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
			uc.setRequestProperty("Authorization", basicAuth);
			uc.setConnectTimeout(7000);

			System.out.println("Printing Data");
			BufferedReader br = new BufferedReader(new InputStreamReader((uc.getInputStream())));
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
