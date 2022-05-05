package com.example.concessionaria_mobile.view.listener

import android.view.View
import com.example.concessionaria_mobile.service.model.seller.Seller

interface SellerListener {
    fun onButtonClick(id: Int)
    fun onRadioClick(seller: Seller)
    fun onRowSellerClick(id: Int)
}