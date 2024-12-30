package com.example.map_gend

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.map_gend.adapter.AdapterWisata
import com.example.map_gend.model.ModelWisata

class ListWisataActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        val listWisata = listOf<ModelWisata>(
            ModelWisata(
                "Bromo",
                "Probolinggo",
                R.drawable.bromo,
                "Gunung Bromo terletak di Kabupaten Probolinggo. Gunung Bromo memiliki ketinggian sekitar 2392 mdpl. Memiliki kawah yang menjadi objek utama yang sering dikunjungi oleh wisatawan asing maupun lokal. Untuk sampai di bibir kawah, para wisatawan harus menaiki tangga yang cukup panjang.",
                -7.9424929,
                112.9324125
            ),
            ModelWisata(
                "Raja Ampat",
                "Papua",
                R.drawable.raja_ampat,
                "Kepulauan Raja Ampat merupakan rangkaian empat gugusan pulau yang berdekatan dan berlokasi di barat bagian Kepala Burung (Vogelkoop) Pulau Papua. Secara administrasi, gugusan ini berada di bawah Kabupaten Raja Ampat, Provinsi Papua Barat.",
                -0.955724,
                130.309192
            ),
            ModelWisata(
                "Candi Borobudur",
                "Magelang",
                R.drawable.candi_borobudur,
                "",
                -7.6078737,
                110.1992454
            ),
            ModelWisata(
                "Banda Neira",
                "Maluku",
                R.drawable.banda_neira,
                "Banda Neira dikenal dengan keindahan alamnya, sejarah kolonialnya, dan sebagai salah satu tempat penting dalam sejarah perdagangan rempah-rempah di Indonesia. Pulau ini juga menjadi tempat pengasingan Mohammad Hatta, sehingga di sana terdapat saksi bisu perjuangannya untuk kemerdekaan Indonesia.",
                -4.5177166,
                129.9030837
            )
        )

        // panggil adapter
        val adapterWisata = AdapterWisata(listWisata)

        // recycler view
        val rv_wisata: RecyclerView = findViewById(R.id.rv_wisata)
        rv_wisata.adapter = adapterWisata

        // set layout untuk recycler view
        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@ListWisataActivity)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}