package com.example.concessionaria_mobile.view.viewholder

import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.R
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.view.listener.SellerListener

class SellerViewHolder(itemView: View, private val listener: SellerListener, val typeScreen: Int) : RecyclerView.ViewHolder(itemView) {

    fun bind(seller: Seller, mSelectedSeller: Seller?){
        val nameSeller = itemView.findViewById<TextView>(R.id.name_seller)
        val ageSeller = itemView.findViewById<TextView>(R.id.text_age_seller)

        val radioSeller = itemView.findViewById<RadioButton>(R.id.radio_seller)
        val layoutSeller = itemView.findViewById<ConstraintLayout>(R.id.layout_row_seller)
        val buttonSellerInfo = itemView.findViewById<Button>(R.id.button_info_seller)

        nameSeller.text = seller.name
        ageSeller.text = seller.age.toString()

        if(typeScreen == ConstantsHelper.SELLER.SCREEN.SELLER){
            radioSeller.visibility = View.INVISIBLE
            buttonSellerInfo.visibility = View.VISIBLE

            layoutSeller.setOnClickListener{
                seller.id?.let { it1 -> listener.onRowSellerClick(it1) }
            }

            buttonSellerInfo.setOnClickListener{
                seller.id?.let { it1 -> listener.onButtonClick(it1) }
            }

        }else{
            buttonSellerInfo.visibility = View.INVISIBLE
            radioSeller.isChecked = seller == mSelectedSeller
            radioSeller.setOnClickListener { listener.onRadioClick(seller) }
        }

    }
}