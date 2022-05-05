package com.example.concessionaria_mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.databinding.ActivityInfoSellerBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.view.adapter.SelledVehiclesAdapter
import com.example.concessionaria_mobile.viewmodel.InfoSellerViewModel

class InfoSellerActivity : AppCompatActivity() {

    private val mActivityInfoSellerBinding: ActivityInfoSellerBinding by lazy{
        ActivityInfoSellerBinding.inflate(layoutInflater)
    }

    private lateinit var mInfoSellerViewModel: InfoSellerViewModel
    private val mAdapter: SelledVehiclesAdapter = SelledVehiclesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mActivityInfoSellerBinding.root)
        mInfoSellerViewModel = ViewModelProvider(this).get(InfoSellerViewModel::class.java)

        actionButtonBackScreen()
        loadDataSeller()
        dealWithRecyclerView()
        observer()

    }

    override fun onResume() {
        super.onResume()
        loadVehiclesSelled()
    }

    private fun actionButtonBackScreen(){
        mActivityInfoSellerBinding.buttonBackScreen.setOnClickListener{
            finish()
        }
    }

    private fun loadVehiclesSelled(){
        val bundle = intent.extras
        if(bundle != null){
            val id = bundle.getInt(ConstantsHelper.SELLER.SELLER_ID)
            mInfoSellerViewModel.loadSelledVehicles(id)
        }
    }

    private fun observer() {
        ViewTreeLifecycleOwner.get(mActivityInfoSellerBinding.root)?.let { it ->
            mInfoSellerViewModel.vehicleList.observe(
                it,
                Observer {
                    mAdapter.updateVehicle(it)
                }
            )
        }
    }


    private fun dealWithRecyclerView() {
        val recycler: RecyclerView = mActivityInfoSellerBinding.listSelledVehicles
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = mAdapter
    }

    private fun loadDataSeller(){
        val bundle = intent.extras
        if(bundle != null){
            val id = bundle.getInt(ConstantsHelper.SELLER.SELLER_ID)
            val seller = mInfoSellerViewModel.loadSeller(id)
            mActivityInfoSellerBinding.nameSeller.text = seller.name
            mActivityInfoSellerBinding.ageSeller.text = seller.age.toString()

        }
    }
}