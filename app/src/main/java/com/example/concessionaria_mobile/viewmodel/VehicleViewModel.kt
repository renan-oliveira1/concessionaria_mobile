package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.VehicleRepository

class VehicleViewModel(application: Application) : AndroidViewModel(application) {

    private val mVehicleRepository: VehicleRepository = VehicleRepository(application.applicationContext)

    private val mVehicleList = MutableLiveData<List<Vehicle>>()
    val vehicleList: LiveData<List<Vehicle>> = mVehicleList

    fun load(){
        mVehicleList.value = mVehicleRepository.findNotSelledVehicles()
    }


}