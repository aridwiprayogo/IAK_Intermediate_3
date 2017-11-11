package com.project.iak_interm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class Detail_Produk : AppCompatActivity() {
    private var tv_name: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__produk)
        tv_name = findViewById<View>(R.id.tv_name) as TextView?
        tv_name!!.text = intent.getStringExtra("name")
    }
}
