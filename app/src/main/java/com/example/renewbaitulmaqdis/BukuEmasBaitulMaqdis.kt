package com.example.renewbaitulmaqdis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BukuEmasBaitulMaqdis : AppCompatActivity() {

    private lateinit var rv_bukuEmas: RecyclerView
    private var listBukuEmas: ArrayList<BukuEmasBM> = arrayListOf()

    companion object {
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_NAME = "extra_name"
        const val E_DETAIL = "e_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku_emas_baitul_maqdis)
        val barTitle = intent.getStringExtra(BukuBaitulMaqdis.EXTRA_NAME)
        supportActionBar?.title = barTitle

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgReceived: ImageView = findViewById(R.id.img_item_photo_received)
        val tvReceived: TextView = findViewById(R.id.tv_item_name_received)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_buku)

        //val btnVideo: Button = findViewById(R.id.btn_pesan_buku)
        //btnVideo.setOnClickListener(this)

        val name = intent.getStringExtra(BukuBaitulMaqdis.EXTRA_NAME)
        val detail = intent.getStringExtra(BukuBaitulMaqdis.E_DETAIL)
        val photo = intent.getIntExtra(BukuBaitulMaqdis.EXTRA_IMG, 0)

        val textName = "$name"
        tvReceived.text = textName

        val textDetail = "$detail"
        tvDetailReceived.text = textDetail

        // set recycler view
        rv_bukuEmas = findViewById(R.id.rv_bukuEmas)
        rv_bukuEmas.setHasFixedSize(true)

        listBukuEmas.addAll(DataBukuEmasBM.listBukuEmasBM)
        showRecyclerBukuKecil()

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(350, 350))
            .into(imgReceived)
    }

    private fun showRecyclerBukuKecil(){
        rv_bukuEmas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val adapterBukuEmas = AdapterBukuEmas(listBukuEmas)
        rv_bukuEmas.adapter = adapterBukuEmas
    }

}