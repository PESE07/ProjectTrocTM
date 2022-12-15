package com.example.wlt_groupe03.dtos

import java.sql.Date

data class DtoInputTroc(val id: Int, val name:String, val urlImage:String, val publicationDate: Date, val categoryName:String, val description:String)