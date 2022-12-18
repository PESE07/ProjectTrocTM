package com.example.wlt_groupe03.dtos

import android.os.Parcel
import android.os.Parcelable
import java.sql.Date
import java.text.DateFormat

data class DtoInputTroc(val id: Int, val name:String, val urlImage:String, val publicationDate: String, val categoryName:String, val description:String)