package com.example.concessionaria_mobile.service.model.seller

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle

@Entity(tableName = "seller")
data class Seller(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int) {

}