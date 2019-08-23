package com.sucho.placepickerexample

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
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
        findViewById<ImageButton>(R.id.imageButton2).setOnClickListener {
            alert()
        }

        findViewById<Button>(R.id.rUser).setOnClickListener {
            intent = Intent(this,acount::class.java)
            startActivity(intent)
        }
    }
    /////////////////

    private fun alert(){


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Info")
        builder.setMessage("Welcome to TRA-admin app, here you can register new users and make orders and check orders progress")
        builder.setPositiveButton("ok",{ dialogInterface: DialogInterface, i: Int -> })
        builder.show()
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

