package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.dtos.DtoInputTroc


class DetailArticleFragment(article : DtoInputTroc) : Fragment() {
    private val trocAdapter = DetailArticleAdapter(article)
    private val articleSelectionne = article
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_article, container, false)
        val viewHolder = ViewHolder(view)

        onBindViewHolder(viewHolder)
        return view
    }

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleView: TextView = itemView.findViewById(R.id.tv_descriptionArticle)

        val imageView : ImageView = itemView.findViewById(R.id.iv_imageArticle)
        override fun toString(): String {
            return super.toString() + " '" + titleView.text + "'"
        }
    }

    

    fun onBindViewHolder(holder: ViewHolder) {
        val item = articleSelectionne

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.titleView.text = item.description

    }




}