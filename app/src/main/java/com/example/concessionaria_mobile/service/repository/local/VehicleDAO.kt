package com.example.concessionaria_mobile.service.repository.local

import androidx.room.*
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle

@Dao
interface VehicleDAO {
    @Insert
    fun save(vehicle: Vehicle): Long

    @Query("SELECT * FROM vehicle")
    fun listAll(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE id = :idVehicle")
    fun listOne(idVehicle: Int): Vehicle

    @Query("SELECT * FROM vehicle WHERE seller_id IS NULL")
    fun listNotSelledVehicles(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE seller_id = :idSeller")
    fun listSelledVehicles(idSeller: Int): List<Vehicle>

    @Update
    fun update(vehicle: Vehicle): Int

    @Delete
    fun delete(vehicle: Vehicle): Int
}