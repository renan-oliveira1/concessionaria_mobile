package com.example.concessionaria_mobile.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle

@Database(entities = [Vehicle::class, Seller::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun vehicleDAO(): VehicleDAO
    abstract fun sellerDAO(): SellerDAO

    companion object{
        private lateinit var INSTANCE: AppDataBase

        fun getDataBase(context: Context): AppDataBase {
            if(!::INSTANCE.isInitialized){
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, AppDataBase::class.java, "dealership.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}