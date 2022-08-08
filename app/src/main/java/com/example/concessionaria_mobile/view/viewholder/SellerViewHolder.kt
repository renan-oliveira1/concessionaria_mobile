package com.example.concessionaria_mobile.view.viewholder

import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.databinding.RowSellerBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.view.listener.SellerListener

class SellerViewHolder(private val binding: RowSellerBinding, private val listener: SellerListener, val typeScreen: Int) : RecyclerView.ViewHolder(binding.root) {

    fun bind(seller: Seller, mSelectedSeller: Seller?){

        binding.nameSeller.text = seller.name
        binding.textAgeSeller.text = seller.age.toString()

        if(typeScreen == ConstantsHelper.SELLER.SCREEN.SELLER){
            binding.radioSeller.visibility = View.INVISIBLE
            binding.buttonInfoSeller.visibility = View.VISIBLE

            binding.layoutRowSeller.setOnClickListener{
                seller.id?.let { it1 -> listener.onRowSellerClick(it1) }
            }

            binding.buttonInfoSeller.setOnClickListener{
                seller.id?.let { it1 -> listener.onButtonClick(it1) }
            }

        }else{
            binding.buttonInfoSeller.visibility = View.INVISIBLE
            binding.radioSeller.isChecked = seller == mSelectedSeller
            binding.radioSeller.setOnClickListener { listener.onRadioClick(seller) }
        }

    }
}