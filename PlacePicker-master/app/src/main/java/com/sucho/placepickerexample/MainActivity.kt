package com.sucho.placepickerexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_place_picker_butto).setOnClickListener {

            val intent = Intent(this,Main3Activity::class.java)
            startActivity(intent)

        }
        findViewById<Button>(R.id.orderList).setOnClickListener {
            val intent = Intent(this,Main2Activity::class.java)
            startActivity(intent)
        }
    }


}

class order(val loctionLongTude:String
            , val locationLatetude:String
            , val destinationLongtude:String
            , val destinationLatetude:String
            , val orderName:String
            , val size:String){
    constructor():this("0.0","0.0","0.0","0.0","0.0","0.0"){

    }
}

