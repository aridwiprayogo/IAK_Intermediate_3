package com.project.iak_interm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DetailActivity : AppCompatActivity() {
    var tv_name: TextView? = null
    var img: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tv_name = findViewById(R.id.tv_name)
        img = findViewById(R.id.img)

        val intent = intent

        Glide.with(this).load(intent.getStringExtra("img"))
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img)

        tv_name?.text = intent.getStringExtra("nama")
    }
}
