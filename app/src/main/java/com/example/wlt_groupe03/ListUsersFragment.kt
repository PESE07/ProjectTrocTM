package com.example.wlt_groupe03


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

import android.location.Location

import android.location.LocationManager
import android.net.Uri
import androidx.core.app.ActivityCompat


import androidx.core.content.ContextCompat.getSystemService
import com.example.wlt_groupe03.dtos.DtoInputArticle
import com.example.wlt_groupe03.dtos.DtoUser
import com.example.wlt_groupe03.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ListUsersFragment : Fragment() {

    private val userList:ArrayList<DtoUser> = arrayListOf()
    private val trocAdapter = ListUsersAdapter(userList)
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_users, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = trocAdapter.apply {
                    onItemLocationOnLongClickListener = {
                        val REQUEST_LOCATION_PERMISSION = 1

                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)

                            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            activity?.let { it1 -> ActivityCompat.requestPermissions(it1, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_LOCATION_PERMISSION) }


                        }
                        val locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                        val positionUtilisateur = it.localite
                        val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                        val uri = "http://maps.google.com/maps?saddr=${location?.latitude},${location?.longitude}&daddr=${positionUtilisateur}"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))

                        intent.`package` = "com.google.android.apps.maps"
                        startActivity(intent)
                    }
                }
            }
        }
        return view
    }

    companion object {


        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListUsersFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    fun replaceArticleList(list: List<DtoUser>){
        userList.clear()
        userList.addAll(list)
        trocAdapter.notifyDataSetChanged()
    }
}