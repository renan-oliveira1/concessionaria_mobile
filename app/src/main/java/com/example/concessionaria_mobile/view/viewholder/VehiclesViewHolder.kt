package com.example.concessionaria_mobile.view.viewholder


import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.databinding.RowVehicleBinding
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.view.listener.VehicleListener

class VehiclesViewHolder(private val binding: RowVehicleBinding, val listener: VehicleListener) : RecyclerView.ViewHolder(binding.root) {

    fun bind(vehicle: Vehicle){

        binding.nameVehicle.text = vehicle.name
        binding.modelVehicle.text = vehicle.model
        binding.valueVehicle.text = String.format("%.2f", vehicle.value)

        binding.nameVehicle.setOnClickListener{
            vehicle.id?.let { it1 -> listener.onClick(it1) }
        }

        binding.buttonSell.setOnClickListener{
            vehicle.id?.let { it1 -> listener.onSell(it1) }
        }


    }

}