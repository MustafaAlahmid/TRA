package com.sucho.placepickerexample

class Order(
    val loctionLongTude:String, val locationLatetude:String,
    val destinationLongtude:String,
    val destinationLatetude:String, val size:String,
    val orderName:String
){
    constructor():this(""
        ,""
        ,""
        ,""
        ,""
        ,""
    )
}