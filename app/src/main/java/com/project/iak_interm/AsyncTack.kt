package com.project.iak_interm

import android.content.Context
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*

/**
 * Created by knalb on 05/11/17.
 */

class AsyncTack(private val recyclerView: RecyclerView, private val context: Context) : AsyncTask<String, String, String>() {

    private val TAG = AsyncTack::class.java.getSimpleName()

    //di jalankan pertama kali
    override fun onPreExecute() {
        Log.e(TAG, "Start Asynctask")
    }

    // di jalankan setelah onPreExecute
    override fun doInBackground(vararg strings: String): String? {
        val okHttpClient = OkHttpClient()

        // reques ambil data
        val request = Request.Builder()
                .url(Api.url)
                .get()
                .build()

        try {
            // get request data dari api bukalapak
            val response = okHttpClient.newCall(request).execute()
            return response.body().string()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }

    // di jalankan setelah doInBackground
    override fun onPostExecute(s: String?) {
        if (s == null) {

        } else {
            // tampil kan data json result

            try {
                val jsonObject = JSONObject(s)
                val jsonArray = jsonObject.getJSONArray("products")


                val data = ArrayList<ModelData>()

                for (i in 0 until jsonArray.length()) {
                    val `object` = jsonArray.getJSONObject(i)

                    Log.e("nama_produk", `object`.getString("name"))

                    val modelData = ModelData()
                    modelData.name = `object`.getString("name")

                    val imageJson = `object`.getJSONArray("small_images")

                    for (j in 0 until imageJson.length()) {
                        modelData.image = imageJson.getString(j)
                    }

                    data.add(modelData)
                }
                val view = AdapterRecyclerView(data, context)
                recyclerView.adapter = view

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            Log.e(TAG, s)
        }
    }
}
