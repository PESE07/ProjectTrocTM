package com.example.wlt_groupe03

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.wlt_groupe03.placeholder.PlaceholderContent.PlaceholderItem
import com.example.wlt_groupe03.databinding.FragmentListArticleBinding
import com.example.wlt_groupe03.databinding.FragmentListArticleItemBinding
import com.example.wlt_groupe03.dtos.DtoInputTroc
import retrofit2.http.Url
import java.net.HttpURLConnection
import java.net.URL

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TrocRecyclerViewAdapter(
    private val values: List<DtoInputTroc>

) : RecyclerView.Adapter<TrocRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentListArticleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.titleView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentListArticleItemBinding) :


        RecyclerView.ViewHolder(binding.root) {

        val titleView: TextView = binding.tvTrocItemTitle

        val imageView : ImageView = binding.tvTrocItemImage


        override fun toString(): String {
            return super.toString() + " '" + titleView.text + "'"
        }
    }

}