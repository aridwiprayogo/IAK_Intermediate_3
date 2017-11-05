package com.example.android.indonesiaandroidkejar3;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by MYWINDOWS on 05/11/2017.
 */

public class AsyncTask extends android.os.AsyncTask<String, String, String>{
    private String TAG = AsyncTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "Start Async task" );
    }

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Api.url)
                .get()
                .build();
        try{
            Response response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s==null){

        }else {
            Log.e(TAG, s);
        }
    }
}
