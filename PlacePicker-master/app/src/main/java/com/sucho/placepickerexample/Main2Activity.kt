package com.sucho.placepickerexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.*

class Main2Activity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var orderList:MutableList<order>
    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        orderList = mutableListOf()
        listview = findViewById(R.id.listView)
        ref = FirebaseDatabase.getInstance().getReference("Orders")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    orderList.clear()
                    for (e in p0.children) {
                        val order1 = e.getValue(order::class.java)
                        orderList.add(order1!!)
                    }
                    val adapter = orderAdapter(this@Main2Activity, R.layout.order, orderList)
                    listview.adapter = adapter
                }
            }
        })
        listview.setOnItemClickListener { parent, view, position, id ->

            val name = orderList.get(position).orderName
            val Llong = orderList.get(position).loctionLongTude
            val Llate = orderList.get(position).locationLatetude
            val Dlate = orderList.get(position).destinationLatetude
            val Dlong = orderList.get(position).destinationLongtude

            intent = Intent(this,MapsActivity::class.java)
                .putExtra("name",name)
                .putExtra("Llong",Llong)
                .putExtra("Llate",Llate)
                .putExtra("Dlong",Dlong)
                .putExtra("Dlate",Dlate)
            startActivity(intent)
        }

    }


}

