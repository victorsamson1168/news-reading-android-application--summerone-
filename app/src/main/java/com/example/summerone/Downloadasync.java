package com.example.summerone;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



    public class Downloadasync extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            String fin="";
            URL url=null;
            HttpURLConnection connection=null;


            try {
                url=new URL(strings[0]);
                connection=(HttpURLConnection) url.openConnection();
                InputStream in=connection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));


                while(result!=null){
                    result=bufferedReader.readLine();
                    fin+=result;


                }
                return fin;

            }  catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }

        }
    }


