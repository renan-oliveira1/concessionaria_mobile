package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.service.repository.SellerRepository

class SellerViewModel(application: Application) : AndroidViewModel(application) {

    private var mSellerRepository: SellerRepository = SellerRepository(application.applicationContext)

    private val mSellerList = MutableLiveData<List<Seller>>()
    val sellerList: LiveData<List<Seller>> = mSellerList


    fun load(){
        mSellerList.value = mSellerRepository.findAll()
    }
}