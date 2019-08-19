package com.sucho.placepickerexample



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView



class orderAdapter (var mCtx: Context, var resorce:Int, var item: MutableList<order>)
    : ArrayAdapter<order>(mCtx,resorce,item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resorce,null)

        val textView5:TextView = view.findViewById(R.id.listText5)
        val textView6:TextView = view.findViewById(R.id.listText6)






        val user: order = item[position]
        val llong = user.loctionLongTude
        val llate =user.locationLatetude
        val dlong = user.destinationLongtude
        val dlate= user.destinationLatetude
        textView5.text = user.size
        textView6.text = user.orderName



        return view
    }
}