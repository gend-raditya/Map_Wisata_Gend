package com.example.map_gend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.map_gend.databinding.ActivityDetailWisataMapBinding

class DetailWisataMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailWisataMapBinding
    private lateinit var nama_lokasi_wisata: TextView
    private lateinit var gambar_wisata: ImageView
    private lateinit var deskripsi_wisata: TextView
    private lateinit var btn_lokasi_wisata: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailWisataMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nama_lokasi_wisata = findViewById(R.id.nama_lokasi_wisata)
        gambar_wisata = findViewById(R.id.gambar_wisata)
        deskripsi_wisata = findViewById(R.id.deskripsi_wisata)
        btn_lokasi_wisata = findViewById(R.id.btn_lokasi_wisata)


        btn_lokasi_wisata.setOnClickListener(){
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // mengambil data dari intent
        val namaLokasiWisata = intent.getStringExtra("namaLokasiWisata")
        val gambarWisata = intent.getIntExtra("gambarWisata", 0)
        val deskripsiWisata = intent.getStringExtra("deskripsiWisata")
        val lattitude = intent.getDoubleExtra("lattitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        nama_lokasi_wisata.text = namaLokasiWisata
        gambar_wisata.setImageResource(gambarWisata)
        deskripsi_wisata.text = deskripsiWisata

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}