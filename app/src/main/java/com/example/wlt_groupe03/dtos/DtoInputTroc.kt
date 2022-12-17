package com.example.wlt_groupe03.dtos

import android.os.Parcel
import android.os.Parcelable
import java.sql.Date
import java.text.DateFormat

data class DtoInputTroc(val id: Int, val name:String, val urlImage:String, val publicationDate: String, val categoryName:String, val description:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(urlImage)
        parcel.writeString(publicationDate)
        parcel.writeString(categoryName)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DtoInputTroc> {
        override fun createFromParcel(parcel: Parcel): DtoInputTroc {
            return DtoInputTroc(parcel)
        }

        override fun newArray(size: Int): Array<DtoInputTroc?> {
            return arrayOfNulls(size)
        }
    }
}