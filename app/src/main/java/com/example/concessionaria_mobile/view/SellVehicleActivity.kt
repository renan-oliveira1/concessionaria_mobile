package com.example.concessionaria_mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.databinding.ActivitySellVehicleBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.view.adapter.SellerAdapter
import com.example.concessionaria_mobile.view.listener.SellerListener
import com.example.concessionaria_mobile.viewmodel.SellVehicleViewModel

class SellVehicleActivity : AppCompatActivity() {

    private val binding: ActivitySellVehicleBinding by lazy{
        ActivitySellVehicleBinding.inflate(layoutInflater)
    }

    private lateinit var mSellVehicleViewModel: SellVehicleViewModel
    private val mSellerAdapter: SellerAdapter = SellerAdapter()
    private lateinit var mSellerListener: SellerListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        mSellVehicleViewModel = ViewModelProvider(this).get(SellVehicleViewModel::class.java)

        loadData()
        dealWithRecyclerView()
        actionButtonSell()
        dealWithListener()
        dealWithAdapter()
        observer()

    }

    override fun onResume() {
        super.onResume()
        mSellVehicleViewModel.loadSellers()
    }

    private fun actionButtonSell(){
        binding.buttonSell.setOnClickListener{
            val bundle = intent.extras
            if(bundle != null) {
                val vehicleId = bundle.getInt(ConstantsHelper.VEHICLE.VEHICLE_ID)
                mSellVehicleViewModel.updateSellVehicles(vehicleId)
            }
            finish()
        }
    }

    private fun observer() {
        ViewTreeLifecycleOwner.get(binding.root)?.let {
            mSellVehicleViewModel.sellerList.observe(
                it,
                Observer {
                    mSellerAdapter.updateSeller(it)
                }
            )
        }
        mSellVehicleViewModel.getSelectedSeller().observe(this, Observer {
            mSellerAdapter.updateSelectedSeller(it)
        })
    }

    private fun dealWithListener(){
        mSellerListener = object: SellerListener{
            override fun onButtonClick(id: Int) {
                TODO("Not yet implemented")
            }

            override fun onRadioClick(seller: Seller) {
                mSellVehicleViewModel.setSelectedSeller(seller)
            }

            override fun onRowSellerClick(id: Int) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun dealWithRecyclerView() {
        val recycler: RecyclerView = binding.listSellers
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = mSellerAdapter
    }

    private fun dealWithAdapter(){
        mSellerAdapter.attachTypeScreen(ConstantsHelper.SELLER.SCREEN.SELLER_SELL_VEHICLE)
        mSellerAdapter.attachListener(mSellerListener)

    }

    private fun loadData(){
        val bundle = intent.extras
        if(bundle != null){
            val vehicleId = bundle.getInt(ConstantsHelper.VEHICLE.VEHICLE_ID)
            val vehicle = mSellVehicleViewModel.loadVehicle(vehicleId)

            binding.nameVehicle.text = vehicle.name
            binding.modelVehicle.text = vehicle.model
            binding.valueVehicle.text = String.format("%.2f", vehicle.value)
            binding.textValueComission.text = String.format("%.2f", vehicle.calculateComission())
        }
    }

}