package com.example.evsandroid53.httpclient;

import android.os.AsyncTask;

import com.example.evsandroid53.Constants;
import com.example.evsandroid53.entities.UserEntity;
import com.example.evsandroid53.model.UserModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AsycAPI extends AsyncTask<UserEntity, Void, UserModel> {
    @Override
    protected UserModel doInBackground(UserEntity... userEntities) {
        String name=userEntities[0].getFirstName();
        String password=userEntities[0].getLastName();

        URLConnection connection=null; // connectivity
        URL url=null; // URL path
        StringBuilder builder=null;
        OutputStreamWriter writer= null; // sending request
        BufferedReader reader=null; // reading response
        String data="";
        try {
            data= URLEncoder.encode("name","UTF-8")+"="+
                    URLEncoder.encode(name,"UTF-8")+"&"+
                    URLEncoder.encode("password","UTF-8")+"="+
                    URLEncoder.encode(password,"UTF-8");
            url = new URL(Constants.initAddr_POST);
            connection=url.openConnection();
            connection.setDoOutput(true);
            writer= new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();
            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            builder= new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null){
                builder.append(line);
            }

            System.out.println(builder.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    // userID  + userName

}
