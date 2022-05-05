package com.example.concessionaria_mobile.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle

class SelledVehiclesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(vehicle: Vehicle) {
        val vehicleName = itemView.findViewById<TextView>(R.id.name_vehicle)
        val vehicleModel = itemView.findViewById<TextView>(R.id.model_vehicle)
        val vehicleValue = itemView.findViewById<TextView>(R.id.value_vehicle)
        val vehicleComission =itemView.findViewById<TextView>(R.id.text_comission)

        vehicleName.text = vehicle.name
        vehicleModel.text = vehicle.model
        vehicleValue.text = String.format("%.2f", vehicle.value)
        vehicleComission.text = String.format("%.2f", vehicle.calculateComission())
    }
}