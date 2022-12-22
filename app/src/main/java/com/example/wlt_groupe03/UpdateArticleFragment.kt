package com.example.wlt_groupe03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wlt_groupe03.databinding.FragmentUpdateArticleBinding
import com.example.wlt_groupe03.dtos.DtoInputTroc


class UpdateArticleFragment(article : DtoInputTroc) : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_update_article, container, false)
        val viewHolder = ViewHolder(view)
        onBindViewHolder(viewHolder)

        viewHolder.buttonModify.setOnClickListener{

            Toast.makeText(it.context, "${articleSelectionne.id}", Toast.LENGTH_SHORT).show()

            viewModel.launchUpdateArticle(viewHolder.nameView.text.toString(), viewHolder.descriptionView.text.toString(),
                viewHolder.urlView.text.toString(), articleSelectionne.id)
        }

        return view
    }

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val descriptionView: TextView = itemView.findViewById(R.id.tv_descriptionArticle)

        val imageView : ImageView = itemView.findViewById(R.id.iv_imageArticle)

        val nameView : TextView = itemView.findViewById(R.id.et_name_article)

        val urlView : TextView = itemView.findViewById(R.id.et_url_article)

        val buttonModify : Button = itemView.findViewById(R.id.btn_modify_article)

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

        holder.urlView.text = item.urlImage


    }




}