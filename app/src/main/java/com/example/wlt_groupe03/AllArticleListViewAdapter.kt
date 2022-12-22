package com.example.wlt_groupe03

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.dtos.DtoInputTroc


class AllArticleListViewAdapter(private val values: List<DtoInputTroc>) : RecyclerView.Adapter<AllArticleListViewAdapter.ViewHolder>() {

    var onItemDetailOnClickListener: ((item: DtoInputTroc) -> Unit)? = null


    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleView: TextView = itemView.findViewById(R.id.tv_nomArticle)

        val imageView : ImageView = itemView.findViewById(R.id.iv_articleImage)
        override fun toString(): String {
            return super.toString() + " '" + titleView.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_article_item,parent,false)


        return ViewHolder(v)

    }


    override fun getItemCount(): Int = values.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.titleView.text = item.name

        holder.itemView.setOnClickListener {
            val item = values[position]
            onItemDetailOnClickListener?.invoke(item)
        }
    }


}