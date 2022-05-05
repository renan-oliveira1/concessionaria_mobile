package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.SellerRepository
import com.example.concessionaria_mobile.service.repository.VehicleRepository

class SellVehicleViewModel(application: Application): AndroidViewModel(application) {

    private var mVehicleRepository: VehicleRepository = VehicleRepository(application)
    private var mSellerRepository: SellerRepository = SellerRepository(application)

    private val mSellerList = MutableLiveData<List<Seller>>()
    val sellerList: LiveData<List<Seller>> = mSellerList


    private val mSelectedSeller = MutableLiveData<Seller>()

    fun loadVehicle(vehicleId: Int): Vehicle {
        return mVehicleRepository.findOne(vehicleId)
    }

    fun loadSellers() {
        mSellerList.value = mSellerRepository.findAll()
    }

    fun setSelectedSeller(seller: Seller){
        mSelectedSeller.value = seller
    }

    fun getSelectedSeller() = mSelectedSeller

    fun updateSellVehicles(vehicleId: Int) {
        val vehicle = loadVehicle(vehicleId)
        vehicle.sellerId = getSelectedSeller().value?.id
        mVehicleRepository.update(vehicle)
    }

}