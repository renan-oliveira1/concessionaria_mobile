package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.VehicleRepository
import java.util.*

class FormVehicleViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mVehicleRepository: VehicleRepository = VehicleRepository(mContext)

    fun saveVehicle(vehicleId: Int, nameVehicle: String, modelVehicle: String, value: Double): Boolean {
        return if(vehicleId == 0){
            val newVehicle = Vehicle(null, nameVehicle,
                modelVehicle, value, null)
            mVehicleRepository.save(newVehicle)
        } else{
            val updateVehicle = Vehicle(vehicleId, nameVehicle,
                modelVehicle, value, null)
            mVehicleRepository.update(updateVehicle)
        }
    }

    fun load(vehicleId: Int): Vehicle {
        return mVehicleRepository.findOne(vehicleId)
    }
}