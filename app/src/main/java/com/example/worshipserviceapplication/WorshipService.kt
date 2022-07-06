package com.example.worshipserviceapplication.Database.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "worship_services")
data class WorshipService (

    @ColumnInfo(name = "itemName")
    var itemName: String,

    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    @ColumnInfo(name = "itemPrice")
    var itemPrice: Int,

){
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}