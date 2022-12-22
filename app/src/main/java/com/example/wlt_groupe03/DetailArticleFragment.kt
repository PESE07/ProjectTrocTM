package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.databinding.FragmentUpdateArticleBinding
import com.example.wlt_groupe03.dtos.DtoInputArticle


class DetailArticleFragment(article : DtoInputArticle) : Fragment() {
    private lateinit var binding: FragmentUpdateArticleBinding
    private val articleSelectionne = article
    private lateinit var viewModel: TrocManagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateArticleBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(TrocManagerViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_detail_article, container, false)
        val viewHolder = ViewHolder(view)
        onBindViewHolder(viewHolder)


        return view
    }

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val descriptionView: TextView = itemView.findViewById(R.id.tv_description_article)

        val imageView : ImageView = itemView.findViewById(R.id.iv_article_image)

        val nameView : TextView = itemView.findViewById(R.id.tv_nom_article)


        override fun toString(): String {
            return super.toString() + " '" + descriptionView.text + "'"
        }
    }



    fun onBindViewHolder(holder: ViewHolder) {
        val item = articleSelectionne

        val url = item.urlImage
        Glide.with(holder.imageView)
            .load(url)
            .into(holder.imageView)

        holder.descriptionView.text = item.description

        holder.nameView.text = item.name




    }
}