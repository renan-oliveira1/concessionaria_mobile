package com.example.concessionaria_mobile.service.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.service.repository.local.AppDataBase

class SellerRepository(context: Context): Repository<Seller> {

    private val mDataBase = AppDataBase.getDataBase(context).sellerDAO()

    override fun save(seller: Seller): Boolean {
        return mDataBase.save(seller) > 0
    }

    override fun update(seller: Seller): Boolean {
        return mDataBase.update(seller) > 0
    }

    override fun delete(seller: Seller): Boolean {
        return mDataBase.delete(seller) > 0
    }

    override fun findAll(): List<Seller> {
        return mDataBase.listAll()
    }

    override fun findOne(id: Int): Seller {
        return mDataBase.listOne(id)
    }

}