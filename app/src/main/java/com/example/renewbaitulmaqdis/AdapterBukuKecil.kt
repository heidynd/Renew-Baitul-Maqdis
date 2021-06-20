package com.example.renewbaitulmaqdis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterBukuKecil(private val listBukuKecilBM: ArrayList<BukuKecilBM>)
    : RecyclerView.Adapter<AdapterBukuKecil.BukuKecilViewHolder>() {

    inner class BukuKecilViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgBukuKecil: ImageView = itemView.findViewById(R.id.img_bukuKecil)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuKecilViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.column_buku_kecil, parent, false)
        return BukuKecilViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuKecilViewHolder, position: Int) {
        val listBukuKecil = listBukuKecilBM[position]

        Glide.with(holder.itemView.context)
            .load(listBukuKecil.bukuKecilBM)
            .apply(RequestOptions().override(300,300))
            .into(holder.imgBukuKecil)
    }

    override fun getItemCount(): Int {
        return listBukuKecilBM.size
    }
}