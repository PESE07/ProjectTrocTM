package com.example.wlt_groupe03

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.wlt_groupe03.placeholder.PlaceholderContent.PlaceholderItem
import com.example.wlt_groupe03.databinding.FragmentListUsersBinding
import com.example.wlt_groupe03.dtos.DtoInputArticle
import com.example.wlt_groupe03.dtos.DtoUser


class ListUsersAdapter(
    private val values: List<DtoUser>
) : RecyclerView.Adapter<ListUsersAdapter.ViewHolder>() {

    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nomUserView: TextView = itemView.findViewById(R.id.tv_nom_user)

        val localiteUserView : TextView = itemView.findViewById(R.id.tv_localite_user)
        override fun toString(): String {
            return super.toString() + " '" + nomUserView.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_users,parent,false)


        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        val nom = item.pseudo

        val localite = item.localite


        holder.nomUserView.text = nom

        holder.localiteUserView.text = localite



        holder.itemView.setOnLongClickListener { view ->

            true
        }
    }

    override fun getItemCount(): Int = values.size

}