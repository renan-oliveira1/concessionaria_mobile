package com.example.concessionaria_mobile.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.databinding.RowSelledVehiclesBinding
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle

class SelledVehiclesViewHolder(private val binding: RowSelledVehiclesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(vehicle: Vehicle) {


        binding.nameVehicle.text = vehicle.name
        binding.modelVehicle.text = vehicle.model
        binding.valueVehicle.text = String.format("%.2f", vehicle.value)
        binding.viewComission.text = String.format("%.2f", vehicle.calculateComission())
    }
}