package com.example.wlt_groupe03

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.placeholder.PlaceholderContent.PlaceholderItem
import com.example.wlt_groupe03.dtos.DtoInputTroc


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TrocRecyclerViewAdapter(private val values: List<DtoInputTroc>) : RecyclerView.Adapter<TrocRecyclerViewAdapter.ViewHolder>() {

    var onItemOnClickListener: ((item: DtoInputTroc)-> Unit)? = null;
    var onItemDeleteOnClickListener: ((item: DtoInputTroc)-> Unit)? = null;



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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.titleView.text = item.name

        holder.itemView.setOnClickListener {
            val item = values[position]
            onItemOnClickListener?.invoke(item)
        }

        holder.itemView.setOnLongClickListener { view ->
            val options = arrayOf("Voir le détail et modifier l'article ", "Supprimer l'article")
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("Choisissez une option")
                .setItems(options) { _, which ->
                    when (which) {
                        0 -> {
                            val item = values[position]
                            onItemOnClickListener?.invoke(item)
                        }
                        1 -> {
                            val item = values[position]
                            onItemDeleteOnClickListener?.invoke(item)
                        }

                    }
                }
            builder.create().show()
            true
        }
    }

    override fun getItemCount(): Int = values.size



}