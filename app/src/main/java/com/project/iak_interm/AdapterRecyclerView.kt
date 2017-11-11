package com.project.iak_interm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by MYWINDOWS on 11/11/2017.
 */

class AdapterRecyclerView(private val data: List<modelData>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolderRecyclerView(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        if (holder is ViewHolderRecyclerView) {
            holder.textView.text = data[position].nama
            holder.view.setOnClickListener {
                val intent = Intent(context, Detail_Produk::class.java)
                intent.putExtra("name", data[position].nama)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private inner class ViewHolderRecyclerView internal constructor(internal val view: View) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView
        internal val textView: TextView

        init {
            imageView = view.findViewById(R.id.iv_photo)
            textView = view.findViewById(R.id.tv_nama)
        }
    }

}
