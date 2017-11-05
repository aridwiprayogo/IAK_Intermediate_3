package com.example.android.indonesiaandroidkejar3

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

/**
 * Created by MYWINDOWS on 05/11/2017.
 */

class AsyncTask : android.os.AsyncTask<String, String, String>() {
    private val TAG = AsyncTask::class.simpleName

    override fun onPreExecute() {
        super.onPreExecute()
        Log.e(TAG, "Start Async task")
    }

    override fun doInBackground(vararg strings: String): String? {
        val okHttpClient = OkHttpClient()

        val request = Request.Builder()
                .url(Api.url)
                .get()
                .build()
        try {
            val response = okHttpClient.newCall(request).execute()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(s: String?) {
        super.onPostExecute(s)
        if (s == null) {

        } else {
            Log.e(TAG, s)
        }
    }
}
