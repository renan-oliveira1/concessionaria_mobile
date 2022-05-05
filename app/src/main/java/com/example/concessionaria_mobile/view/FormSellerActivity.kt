package com.example.concessionaria_mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.concessionaria_mobile.databinding.ActivityFormSellerBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.viewmodel.FormSellerViewModel

class FormSellerActivity : AppCompatActivity() {

    private val mActivityFormSellerBinding: ActivityFormSellerBinding by lazy {
        ActivityFormSellerBinding.inflate(layoutInflater)
    }
    
    private lateinit var mViewModel: FormSellerViewModel
    private var mSellerId: Int = 0

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mActivityFormSellerBinding.root)
        mViewModel = ViewModelProvider(this).get(FormSellerViewModel::class.java)


        actionBtnRegister()
        loadDataToUpdate()

    }

    private fun actionBtnRegister(){
        mActivityFormSellerBinding.buttonRegister.setOnClickListener{
            saveSeller()
            finish()
        }
    }

    private fun saveSeller(){
        val name = mActivityFormSellerBinding.editName.text.toString()
        val age = mActivityFormSellerBinding.editAge.text.toString()

        val successAction = mViewModel.save(mSellerId, name, age)
        if(successAction){
            Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadDataToUpdate(){
        val bundle = intent.extras
        if(bundle != null){
            mSellerId = bundle.getInt(ConstantsHelper.SELLER.SELLER_ID)
            val seller = mViewModel.load(mSellerId)

            mActivityFormSellerBinding.editName.setText(seller.name)
            mActivityFormSellerBinding.editAge.setText(seller.age.toString())

        }
    }
}