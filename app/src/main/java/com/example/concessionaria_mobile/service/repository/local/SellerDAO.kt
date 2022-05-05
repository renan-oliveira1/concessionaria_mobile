package com.example.concessionaria_mobile.service.repository.local

import androidx.room.*
import com.example.concessionaria_mobile.service.model.seller.Seller

@Dao
interface SellerDAO {

    @Insert
    fun save(seller: Seller): Long

    @Query("SELECT * FROM seller")
    fun listAll(): List<Seller>

    @Query("SELECT * FROM seller WHERE id = :idSeller")
    fun listOne(idSeller: Int): Seller

    @Update
    fun update(seller: Seller): Int

    @Delete
    fun delete(seller: Seller): Int
}