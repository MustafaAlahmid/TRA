package com.sucho.placepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.sucho.placepicker.AddressData
import com.sucho.placepicker.Constants
import com.sucho.placepicker.MapType
import com.sucho.placepicker.PlacePicker

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
    }


}

