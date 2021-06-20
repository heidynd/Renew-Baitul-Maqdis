package com.example.renewbaitulmaqdis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterBaitulMaqdis(context: Context, private val listBM: ArrayList<BaitulMaqdis>,
                          private val onItemClickListener: OnItemClickListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_TYPE_BUKU = 1
        const val VIEW_TYPE_VIDEO = 2
        const val VIEW_TYPE_DONASI = 3
    }
    private val context: Context = context

    // lets create customize viewHolder based on the specific or desirable item
    private inner class BukuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNarasumber: TextView = itemView.findViewById(R.id.tv_item_narasumber)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var imgNarasumber: ImageView = itemView.findViewById(R.id.img_narasumber)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
        var btnLink: Button = itemView.findViewById(R.id.btn_link)

        fun bind(position: Int){
            val rvModel = listBM[position]
            tvName.text = rvModel.name
            tvNarasumber.text = rvModel.narasumber

            // settings main photos
            Glide.with(context)
                .load(rvModel.photo)
                .apply(RequestOptions().override(800, 500))
                .into(imgPhoto)

            Glide.with(context)
                .load(rvModel.imgNarasumber)
                .apply(RequestOptions().override(800, 500))
                .into(imgNarasumber)

            btnLink.setOnClickListener {
                onItemClickListener.setOnLinkClicked(listBM[position])
            }
            btnDetail.setOnClickListener {
                onItemClickListener.setOnItemClicked(listBM[position], position)
            }
        }
    }

    private inner class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNarasumber: TextView = itemView.findViewById(R.id.tv_item_narasumber)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var imgNarasumber: ImageView = itemView.findViewById(R.id.img_narasumber)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
        var btnLink: Button = itemView.findViewById(R.id.btn_link)

        fun bind(position: Int){
            val rvModel = listBM[position]
            tvName.text = rvModel.name
            tvNarasumber.text = rvModel.narasumber

            // settings main photos
            Glide.with(context)
                .load(rvModel.photo)
                .apply(RequestOptions().override(800, 500))
                .into(imgPhoto)

            Glide.with(context)
                .load(rvModel.imgNarasumber)
                .apply(RequestOptions().override(800, 500))
                .into(imgNarasumber)

            btnLink.setOnClickListener {
                onItemClickListener.setOnLinkClicked(listBM[position])
            }
            btnDetail.setOnClickListener {
                onItemClickListener.setOnItemClicked(listBM[position], position)
            }
        }
    }

    private inner class DonasiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNarasumber: TextView = itemView.findViewById(R.id.tv_item_narasumber)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var imgNarasumber: ImageView = itemView.findViewById(R.id.img_narasumber)

        fun bind(position: Int){
            val rvModel = listBM[position]
            tvName.text = rvModel.name
            tvNarasumber.text = rvModel.narasumber

            // settings main photos
            Glide.with(context)
                .load(rvModel.photo)
                .apply(RequestOptions().override(800, 500))
                .into(imgPhoto)

            Glide.with(context)
                .load(rvModel.imgNarasumber)
                .apply(RequestOptions().override(800, 500))
                .into(imgNarasumber)

            itemView.setOnClickListener {
                onItemClickListener.setOnItemClicked(listBM[position], position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_BUKU -> {
                return BukuViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.row_buku_bm, parent, false)
                )
            }
            VIEW_TYPE_DONASI -> {
                return DonasiViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.row_donasi_bm, parent, false)
                )
            }
        }
        return VideoViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_video_bm, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listBM.size
    }

    override fun getItemViewType(position: Int): Int {
        return listBM[position].viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (listBM[position].viewType) {
            VIEW_TYPE_BUKU -> {
                (holder as BukuViewHolder).bind(position)
            }
            VIEW_TYPE_DONASI -> {
                (holder as DonasiViewHolder).bind(position)
            }
            else -> {
                (holder as VideoViewHolder).bind(position)
            }
        }
    }

    interface OnItemClickListener{
        fun setOnItemClicked(data: BaitulMaqdis, position: Int)
        fun setOnLinkClicked(data: BaitulMaqdis)
    }
}

/*
override fun onBindViewHolder(holder: BaitulViewHolder, position: Int) {
        val bm = listBM[position]

        // settings button detail with Interface
        holder.btnDetail.setOnClickListener{
            onItemClickListener.setOnItemClicked(listBM[position], position)
        }

        // settings button link with Interface
        holder.btnLink.setOnClickListener {
            onItemClickListener.setOnLinkClicked(listBM[holder.adapterPosition])
        }

        // settings main photos
        Glide.with(holder.itemView.context)
            .load(bm.photo)
            .apply(RequestOptions().override(800, 500))
            .into(holder.imgPhoto)

        // settings narasumber photos
        Glide.with(holder.itemView.context)
            .load(bm.imgNarasumber)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgNarasumber)

        //settings text view
        holder.tvName.text = bm.name
        holder.tvNarasumber.text = bm.narasumber
    }
 */