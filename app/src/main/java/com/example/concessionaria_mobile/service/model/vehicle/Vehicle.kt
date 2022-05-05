package com.example.concessionaria_mobile.service.model.vehicle

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.concessionaria_mobile.service.model.seller.Seller

@Entity(tableName = "vehicle",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Seller::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("seller_id"),
            onDelete = ForeignKey.CASCADE
        )
))
data class Vehicle(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "value") var value: Double,
    @ColumnInfo(name = "seller_id")
    @Nullable var sellerId: Int?
) {


    fun calculateComission() : Double{
        return value*0.03
    }
}