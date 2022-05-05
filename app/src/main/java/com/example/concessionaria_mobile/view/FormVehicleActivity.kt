package com.example.concessionaria_mobile.view


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.concessionaria_mobile.databinding.ActivityFormVehicleBinding
import com.example.concessionaria_mobile.service.constants.ConstantsHelper
import com.example.concessionaria_mobile.viewmodel.FormVehicleViewModel

class FormVehicleActivity: AppCompatActivity(), View.OnClickListener {

    private val mActivityFormVehicleBinding: ActivityFormVehicleBinding by lazy{
        ActivityFormVehicleBinding.inflate(layoutInflater)
    }

    private lateinit var mFormVehicleViewModel: FormVehicleViewModel
    private var mVehicleId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mActivityFormVehicleBinding.root)
        mFormVehicleViewModel = ViewModelProvider(this).get(FormVehicleViewModel::class.java)

        setClickListeners()
        loadDataToUpdate()

    }


    override fun onClick(v: View) {
        val id = v.id

        if(id == mActivityFormVehicleBinding.buttonSave.id){
            val nameVehicle = mActivityFormVehicleBinding.editName.text.toString()
            val modelVehicle = mActivityFormVehicleBinding.editModel.text.toString()
            val value = mActivityFormVehicleBinding.editValue.text.toString().toDouble()

            val successAction = mFormVehicleViewModel.saveVehicle(mVehicleId, nameVehicle, modelVehicle, value)
            if(successAction){
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }

            finish()
        }
    }

    private fun setClickListeners(){
        mActivityFormVehicleBinding.buttonSave.setOnClickListener(this)
    }

    private fun loadDataToUpdate(){
        val bundle = intent.extras
        if(bundle != null){
            mVehicleId = bundle.getInt(ConstantsHelper.VEHICLE.VEHICLE_ID)
            val vehicle = mFormVehicleViewModel.load(mVehicleId)

            mActivityFormVehicleBinding.editName.setText(vehicle.name)
            mActivityFormVehicleBinding.editModel.setText(vehicle.model)
            mActivityFormVehicleBinding.editValue.setText(vehicle.value.toString())

        }
    }
}