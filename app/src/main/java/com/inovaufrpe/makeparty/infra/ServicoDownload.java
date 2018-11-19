package com.inovaufrpe.makeparty.infra;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicoDownload {
    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }


    public static String excuteGet(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("content-type", "application/json;  charset=utf-8");
            connection.setRequestProperty("Content-Language", "pt-BR");
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            InputStream inputStream = getInputStream(connection);
            return getString(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }


    @NonNull
    private static String getString(InputStream inputStream) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuffer response = new StringBuffer();
        while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }

    private static InputStream getInputStream(HttpURLConnection connection) throws IOException {
        InputStream inputStream;
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK)
            inputStream = connection.getErrorStream();
        else
            inputStream = connection.getInputStream();
        return inputStream;
    }

}
