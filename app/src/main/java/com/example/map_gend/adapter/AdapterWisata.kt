package com.example.map_gend.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.map_gend.DetailWisataMapActivity
import com.example.map_gend.R
import com.example.map_gend.model.ModelWisata

class AdapterWisata (
    // data diambil dari model
    val listItemWisata: List<ModelWisata>
): RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // layout pada widget
        val gambarWisata: ImageView = itemView.findViewById(R.id.gambarWisata)
        val namaLokasiWisata: TextView = itemView.findViewById(R.id.namaLokasiWisata)
        val alamatWisata: TextView = itemView.findViewById(R.id.alamatWisata)
        val cardWisata: CardView = itemView.findViewById(R.id.cardWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wisata, parent, false)

        return MyViewHolder(nView)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listItemWisata[position]
        // pertama dari id, yang kedua dari model
        holder.gambarWisata.setImageResource(currentItem.gambarWisata)
        holder.namaLokasiWisata.text = currentItem.namaLokasiWisata
        holder.alamatWisata.text = currentItem.alamatWisata
        // event click pada cardview
        holder.cardWisata.setOnClickListener() {
            val intentDetail = Intent(holder.itemView.context,DetailWisataMapActivity::class.java)
            // kirim data list item wisata ke DetailWisataMapsActivity
            intentDetail.putExtra("namaLokasiWisata", currentItem.namaLokasiWisata)
            intentDetail.putExtra("gambarWisata", currentItem.gambarWisata)
            intentDetail.putExtra("deskripsiWisata", currentItem.deskripsiWisata)
            intentDetail.putExtra("lattitude", currentItem.lattitude)
            intentDetail.putExtra("longitude", currentItem.longitude)

            // menjalankan startActivity intent
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int {
        return listItemWisata.size
    }
}