package com.project.iak_interm

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by MYWINDOWS on 19/11/2017.
 */

class AdapterRecyclerView(private val data: List<ModelData>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHOlderRecyclerView(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHOlderRecyclerView){
        holder.textView.text = data[position].name
        Log.e("appear a text: ", data[position].name)
        Glide.with(context).load(data[position].image)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val i=Intent(context, DetailActivity::class.java)
            i.putExtra("nama", data[position].name)
            i.putExtra("img", data[position].image)
            context.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    private inner class ViewHOlderRecyclerView
    internal constructor(internal val view: View):
            RecyclerView.ViewHolder(view) {

        internal var imageView: ImageView
        internal var textView: TextView
        internal var container: LinearLayout

        init {
            textView = view.findViewById(R.id.tv_nama)
            imageView = view.findViewById(R.id.iv_foto)
            container = view.findViewById(R.id.container)
        }
    }
}
