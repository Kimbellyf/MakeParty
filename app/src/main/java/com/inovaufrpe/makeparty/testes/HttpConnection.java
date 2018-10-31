package com.inovaufrpe.makeparty.testes;

import android.util.Log;


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
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class HttpConnection {


	public static String getSetDataWeb(String url, String method, String data){
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String answer = "";
		
		try{
			ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
			valores.add(new BasicNameValuePair("method", method));
			valores.add(new BasicNameValuePair("json", data));
			
			httpPost.setEntity(new UrlEncodedFormEntity(valores));
			HttpResponse resposta = httpClient.execute(httpPost);
			answer = EntityUtils.toString(resposta.getEntity());
		}
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(ClientProtocolException e){ e.printStackTrace(); }
		catch(IOException e){ e.printStackTrace(); }
		
		return(answer);
	}

    public static String post(String completeUrl, String body) {
        HttpClient httpClient = new DefaultHttpClient();
        String answer;
        HttpPost httpPost = new HttpPost(completeUrl);
        httpPost.setHeader("Content-type", "application/json");
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);

            HttpResponse resposta = httpClient.execute(httpPost);
            answer = EntityUtils.toString(resposta.getEntity());
            Log.i("Script", "ANSWER: "+ answer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return answer;
    }

    public static String get(String completeUrl) {
        HttpClient httpClient = new DefaultHttpClient();
        String answer;
        HttpGet httpGet = new HttpGet(completeUrl);
        httpGet.setHeader("Content-type", "application/json");
        httpGet.addHeader("Authorization", "Bearer "+ Sessao.instance.getSession().getToken());
        try {
            HttpResponse resposta = httpClient.execute(httpGet);
            answer = EntityUtils.toString(resposta.getEntity());
            Log.i("Script", "ANSWER: "+ answer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return answer;
    }


}
