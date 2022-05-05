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
import com.example.concessionaria_mobile.databinding.FragmentSellerBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.service.model.seller.Seller
import com.example.concessionaria_mobile.view.adapter.SellerAdapter
import com.example.concessionaria_mobile.view.listener.SellerListener
import com.example.concessionaria_mobile.viewmodel.SellerViewModel

class SellerFragment : Fragment() {

    private val mFragmentSellerBinding: FragmentSellerBinding by lazy{
        FragmentSellerBinding.inflate(layoutInflater)
    }

    private lateinit var mSellerViewModel: SellerViewModel
    private val mSellerAdapter: SellerAdapter = SellerAdapter()
    private lateinit var mSellerListener: SellerListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = mFragmentSellerBinding.root

        mSellerViewModel =
            ViewModelProvider(this).get(SellerViewModel::class.java)


        actionBtnAddSeller()

        dealWithRecyclerView()
        dealWithListener()
        dealWithAdapter()
        observer()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        mSellerViewModel.load()
    }

    private fun actionBtnAddSeller(){
        mFragmentSellerBinding.buttonAddSeller.setOnClickListener{
            val intent = Intent(context, FormSellerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun dealWithListener(){
        mSellerListener = object: SellerListener{

            override fun onButtonClick(id: Int) {
                val intent = Intent(context, InfoSellerActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(ConstantsHelper.SELLER.SELLER_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onRadioClick(seller: Seller) {
                TODO("Not yet implemented")
            }

            override fun onRowSellerClick(id: Int) {
                val intent = Intent(context, FormSellerActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(ConstantsHelper.SELLER.SELLER_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

    }

    private fun dealWithAdapter(){
        mSellerAdapter.attachTypeScreen(ConstantsHelper.SELLER.SCREEN.SELLER)
        mSellerAdapter.attachListener(mSellerListener)
    }

    private fun dealWithRecyclerView(){
        val recycler: RecyclerView = mFragmentSellerBinding.listSellers
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mSellerAdapter

    }

    private fun observer(){
        mSellerViewModel.sellerList.observe(
            viewLifecycleOwner,
            Observer {
                mSellerAdapter.updateSeller(it)
            }
        )
    }
}