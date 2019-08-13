package com.sucho.placepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sucho.placepicker.AddressData
import com.sucho.placepicker.Constants
import com.sucho.placepicker.MapType
import com.sucho.placepicker.PlacePicker
lateinit var firebaseDatabase: FirebaseDatabase
lateinit var databaseReference: DatabaseReference

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        findViewById<Button>(R.id.open_place_picker_butto).setOnClickListener {
            val intent = PlacePicker.IntentBuilder()
                .setLatLong(59.93863, 30.31413)
                .showLatLong(true)
                .setMapRawResourceStyle(R.raw.map_style)
                .setMapType(MapType.NORMAL)
                .build(this)
            startActivityForResult(intent, Constants.PLACE_PICKER_REQUEST)
        }
        findViewById<Button>(R.id.map1).setOnClickListener {
            findViewById<TextView>(R.id.llate).text = ""
            findViewById<TextView>(R.id.llong).text =""
        }
        findViewById<Button>(R.id.map2).setOnClickListener {
            findViewById<TextView>(R.id.dlate).text = ""
            findViewById<TextView>(R.id.dlong).text =""
        }
        findViewById<Button>(R.id.submit).setOnClickListener {



        }

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {

        if (requestCode == Constants.PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    val addressData = data?.getParcelableExtra<AddressData>(Constants.ADDRESS_INTENT)
                    val a = findViewById<TextView>(R.id.llate)
                    if (a.text == ""){
                        findViewById<TextView>(R.id.llate).text = addressData!!.latitude.toString()
                        findViewById<TextView>(R.id.llong).text = addressData!!.longitude.toString()
                    }else{
                        findViewById<TextView>(R.id.dlate).text = addressData!!.latitude.toString()
                        findViewById<TextView>(R.id.dlong).text = addressData!!.longitude.toString()

                    }





                } catch (e: Exception) {
                    Log.e("MainActivity", e.message)
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
        findViewById<Button>(R.id.submit).setOnClickListener {
            saveData()
        }
    }


    fun saveData(){
        val llong = findViewById<TextView>(R.id.llong).text.toString().trim()
        val llate = findViewById<TextView>(R.id.llate).text.toString().trim()
        val dlong= findViewById<TextView>(R.id.dlong).text.toString().trim()
        val dlate= findViewById<TextView>(R.id.dlate).text.toString().trim()
        val size = findViewById<TextView>(R.id.editText).text.toString().trim()
        val name:String = findViewById<TextView>(R.id.editText2).text.toString().trim()

        val myData = FirebaseDatabase
            .getInstance().getReference("Orders")
        val order = Order(llong,llate,dlong,dlate,size,name)
        val orderID = order.orderName
        myData.child(orderID).setValue(order).addOnCompleteListener {
            Toast.makeText(this,"Order placed",Toast.LENGTH_LONG).show()
        }



    }


}

