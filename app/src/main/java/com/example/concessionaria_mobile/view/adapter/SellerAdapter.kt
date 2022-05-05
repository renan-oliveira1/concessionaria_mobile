package com.example.concessionaria_mobile.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.view.listener.SellerListener
import com.example.concessionaria_mobile.view.viewholder.SellerViewHolder


class SellerAdapter: RecyclerView.Adapter<SellerViewHolder>(){
    private lateinit var mListener: SellerListener
    private var mTypeScreen: Int = 0

    private var mSellerList: List<Seller> = arrayListOf()

    private var mSelectedSeller: Seller? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_seller, parent, false)
        return SellerViewHolder(item, mListener, mTypeScreen)
    }

    override fun onBindViewHolder(holder: SellerViewHolder, position: Int) {
        holder.bind(mSellerList[position], mSelectedSeller)
    }

    override fun getItemCount(): Int {
        return mSellerList.count()
    }

    fun updateSeller(sellers: List<Seller>){
        mSellerList = sellers
        notifyDataSetChanged()
    }

    fun updateSelectedSeller(seller: Seller){
        mSelectedSeller = seller
        notifyDataSetChanged()
    }

    fun attachListener(listener: SellerListener){
        mListener = listener
    }

    fun attachTypeScreen(seller: Int) {
        mTypeScreen = seller
    }
}