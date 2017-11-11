package com.example.android.indonesiaandroidkejar3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by MYWINDOWS on 05/11/2017.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AsyncTask().execute()
    }
}
