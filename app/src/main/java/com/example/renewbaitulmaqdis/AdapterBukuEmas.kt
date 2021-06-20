package com.example.renewbaitulmaqdis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterBukuEmas(private val listBukuEmasBM: ArrayList<BukuEmasBM>)
    : RecyclerView.Adapter<AdapterBukuEmas.BukuEmasViewHolder>() {

    inner class BukuEmasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgBukuEmas: ImageView = itemView.findViewById(R.id.img_bukuEmas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuEmasViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.column_buku_emas, parent, false)
        return BukuEmasViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuEmasViewHolder, position: Int) {
        val listBukuKecil = listBukuEmasBM[position]

        Glide.with(holder.itemView.context)
            .load(listBukuKecil.bukuEmasBM)
            .apply(RequestOptions().override(300,300))
            .into(holder.imgBukuEmas)
    }

    override fun getItemCount(): Int {
        return listBukuEmasBM.size
    }
}