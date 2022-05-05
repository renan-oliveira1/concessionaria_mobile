package com.example.concessionaria_mobile.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concessionaria_mobile.databinding.FragmentVehiclesBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.view.adapter.VehiclesAdapter
import com.example.concessionaria_mobile.view.listener.VehicleListener
import com.example.concessionaria_mobile.viewmodel.VehicleViewModel


class VehiclesFragment : Fragment() {

    private val mFragmentVehicleBinding by lazy{
        FragmentVehiclesBinding.inflate(layoutInflater)
    }

    private lateinit var mVehicleViewModel: VehicleViewModel
    private lateinit var mVehicleListener: VehicleListener
    private var mVehicleAdapter: VehiclesAdapter = VehiclesAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = mFragmentVehicleBinding.root

        mVehicleViewModel =
            ViewModelProvider(this).get(VehicleViewModel::class.java)


        dealWithClicks()
        dealWithRecyclerView()
        dealWithListener()
        mVehicleAdapter.attachListener(mVehicleListener)
        observers()

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onResume() {
        super.onResume()
        mVehicleViewModel.load()
    }

    private fun dealWithClicks(){
        mFragmentVehicleBinding.fab.setOnClickListener{
            val intent: Intent = Intent(context, FormVehicleActivity::class.java)
            startActivity(intent)
        }
    }
    private fun dealWithRecyclerView(){
        val recycler: RecyclerView = mFragmentVehicleBinding.vehiclesToSell
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mVehicleAdapter
    }

    private fun dealWithListener() {
        mVehicleListener = object: VehicleListener{
            override fun onClick(id: Int) {
                val intent = Intent(context, FormVehicleActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(ConstantsHelper.VEHICLE.VEHICLE_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onSell(id: Int) {
                val intent = Intent(context, SellVehicleActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(ConstantsHelper.VEHICLE.VEHICLE_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }
    }

    private fun observers(){
        mVehicleViewModel.vehicleList.observe(
            viewLifecycleOwner,
            Observer {
                mVehicleAdapter.updateVehicles(it)
            }
        )
    }
}