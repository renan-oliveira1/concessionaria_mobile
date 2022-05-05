package com.example.concessionaria_mobile.service.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.local.AppDataBase

class VehicleRepository(context: Context) : Repository<Vehicle>{

    private val mDataBase = AppDataBase.getDataBase(context).vehicleDAO()

    override fun save(vehicle: Vehicle): Boolean {
        return mDataBase.save(vehicle) > 0
    }

    override fun update(vehicle: Vehicle): Boolean {
        return mDataBase.update(vehicle) > 0
    }

    override fun delete(vehicle: Vehicle): Boolean {
        return mDataBase.delete(vehicle) > 0
    }

    override fun findAll(): List<Vehicle> {
        return mDataBase.listAll()
    }

    override fun findOne(id: Int): Vehicle {
        return mDataBase.listOne(id)
    }

    fun findNotSelledVehicles(): List<Vehicle>{
        return mDataBase.listNotSelledVehicles()
    }

    fun findSelledVehicles(idSeller: Int): List<Vehicle>{
        return mDataBase.listSelledVehicles(idSeller)
    }


}