package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.SellerRepository
import com.example.concessionaria_mobile.service.repository.VehicleRepository

class InfoSellerViewModel(application: Application): AndroidViewModel(application){

    private val mContext = application.applicationContext
    private val mVehicleRepository: VehicleRepository = VehicleRepository(mContext)
    private val mSellerRepository: SellerRepository = SellerRepository(mContext)

    private val mVehicleList = MutableLiveData<List<Vehicle>>()
    val vehicleList: LiveData<List<Vehicle>> = mVehicleList


    fun loadSeller(id: Int): Seller {
        return mSellerRepository.findOne(id)
    }

    fun loadSelledVehicles(id: Int) {
        mVehicleList.value = mVehicleRepository.findSelledVehicles(id)
    }
}