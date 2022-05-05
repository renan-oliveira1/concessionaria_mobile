package com.example.concessionaria_mobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.repository.SellerRepository

class FormSellerViewModel(application: Application): AndroidViewModel(application) {

    private val mSellerRepository: SellerRepository = SellerRepository(application)
    private lateinit var mSeller: Seller

    fun save(mSellerId: Int, name: String, age: String): Boolean {
        return if(mSellerId == 0){
            val seller = Seller(null, name, age.toInt())
            mSellerRepository.save(seller)
        }else{
            val seller = Seller(mSellerId, name, age.toInt())
            mSellerRepository.update(seller)
        }
    }

    fun load(id: Int): Seller {
        mSeller = mSellerRepository.findOne(id)
        return mSeller
    }

}