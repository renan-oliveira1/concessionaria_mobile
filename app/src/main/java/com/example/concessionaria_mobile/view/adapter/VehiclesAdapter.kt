package com.example.concessionaria_mobile.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.model.vehicle.Vehicle
import com.example.concessionaria_mobile.view.listener.VehicleListener
import com.example.concessionaria_mobile.view.viewholder.VehiclesViewHolder

class VehiclesAdapter: RecyclerView.Adapter<VehiclesViewHolder>() {

    private lateinit var mListener: VehicleListener

    private var mVehicleList: List<Vehicle> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_vehicle, parent, false)

        return VehiclesViewHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.bind(mVehicleList[position])
    }

    override fun getItemCount(): Int {
        return mVehicleList.count()
    }

    fun updateVehicles(vehicles: List<Vehicle>){
        mVehicleList = vehicles
        notifyDataSetChanged()
    }

    fun attachListener(listener: VehicleListener){
        mListener = listener
    }
}