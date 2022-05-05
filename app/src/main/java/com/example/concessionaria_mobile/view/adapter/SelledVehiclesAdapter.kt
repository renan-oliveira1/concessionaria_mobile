package com.example.concessionaria_mobile.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.view.viewholder.SelledVehiclesViewHolder
import com.example.concessionaria_mobile.view.viewholder.SellerViewHolder

class SelledVehiclesAdapter: RecyclerView.Adapter<SelledVehiclesViewHolder>() {

    private var mVehiclesList: List<Vehicle> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelledVehiclesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_selled_vehicles, parent, false)
        return SelledVehiclesViewHolder(item)
    }

    override fun onBindViewHolder(holder: SelledVehiclesViewHolder, position: Int) {
        holder.bind(mVehiclesList[position])
    }

    override fun getItemCount(): Int {
        return mVehiclesList.count()
    }

    fun updateVehicle(vehicles: List<Vehicle>?) {
        if (vehicles != null) {
            mVehiclesList = vehicles
        }
        notifyDataSetChanged()
    }
}