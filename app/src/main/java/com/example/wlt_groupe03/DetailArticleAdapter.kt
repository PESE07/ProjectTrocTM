package com.example.wlt_groupe03

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.wlt_groupe03.dtos.DtoInputArticle


class DetailArticleAdapter(
    private val values: DtoInputArticle
) : RecyclerView.Adapter<DetailArticleAdapter.ViewHolder>() {


    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleView: TextView = itemView.findViewById(R.id.tv_descriptionArticle)

        val imageView : ImageView = itemView.findViewById(R.id.iv_imageArticle)

        override fun toString(): String {
            return super.toString() + " '" + titleView.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_update_article,parent,false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.titleView.text = item.name


    }

    override fun getItemCount(): Int = 1



}