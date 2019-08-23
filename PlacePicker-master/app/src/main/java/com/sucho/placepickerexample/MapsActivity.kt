package com.sucho.placepickerexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.widget.Button
import android.widget.ImageButton

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.maps.android.SphericalUtil

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var imageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    ////////////////////

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val name = intent.getStringExtra("name")
        val llong = intent.getStringExtra("Llong")
        val llate = intent.getStringExtra("Llate")
        val dlate = intent.getStringExtra("Dlate")
        val dlong = intent.getStringExtra("Dlong")

        // Add a marker in Sydney and move the camera


        val orderDestination = LatLng(dlate.toDouble(), dlong.toDouble())
        mMap.addMarker(MarkerOptions().position(orderDestination).title("order's Destination"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orderDestination, 12f))

        val orderLocation = LatLng(llate.toDouble(), llong.toDouble())
        mMap.addMarker(MarkerOptions().position(orderLocation).title("order's location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orderLocation, 12f))
        val destance = SphericalUtil.computeDistanceBetween(orderDestination, orderLocation)
        findViewById<Button>(R.id.info).setOnClickListener {
            alert(destance)
        }

    }

    private fun alert(dest: Double) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Info")
        builder.setMessage("the distance is: $Int ")
        builder.setPositiveButton("ok", { dialogInterface: DialogInterface, i: Int -> })
        builder.show()
        return

    }
}
