package com.example.concessionaria_mobile.view.viewholder


import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.view.listener.VehicleListener

class VehiclesViewHolder(itemView: View, val listener: VehicleListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(vehicle: Vehicle){

        val nameVehicle = itemView.findViewById<TextView>(R.id.name_vehicle)
        val modelVehicle = itemView.findViewById<TextView>(R.id.model_vehicle)
        val valueVehicle = itemView.findViewById<TextView>(R.id.value_vehicle)
        val sellButton = itemView.findViewById<Button>(R.id.button_sell)

        nameVehicle.text = vehicle.name
        modelVehicle.text = vehicle.model
        valueVehicle.text = String.format("%.2f", vehicle.value)

        nameVehicle.setOnClickListener{
            vehicle.id?.let { it1 -> listener.onClick(it1) }
        }

        sellButton.setOnClickListener{
            vehicle.id?.let { it1 -> listener.onSell(it1) }
        }


    }

}