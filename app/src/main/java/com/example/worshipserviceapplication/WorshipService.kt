package com.example.worshipserviceapplication.Database.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "worship_services")
data class WorshipService (

    @ColumnInfo(name = "firstHymnName")
    var firstHymnName: String,

    @ColumnInfo(name = "firstHymnNumber")
    var firstHymnNumber: String,

    @ColumnInfo(name = "psalm")
    var psalm: String,

    @ColumnInfo(name = "secondHymnName")
    var secondHymnName: String,

    @ColumnInfo(name = "secondHymnNumber")
    var secondHymnNumber: String,

){
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}