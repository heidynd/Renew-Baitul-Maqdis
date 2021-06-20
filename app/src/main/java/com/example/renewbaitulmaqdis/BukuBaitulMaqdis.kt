package com.example.renewbaitulmaqdis

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BukuBaitulMaqdis : AppCompatActivity(), View.OnClickListener {

    private lateinit var rv_bukuKecil: RecyclerView
    private var listBukuKecil: ArrayList<BukuKecilBM> = arrayListOf()

    companion object {
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_NAME = "extra_name"
        const val E_DETAIL = "e_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buku_baitul_maqdis)

        val barTitle = intent.getStringExtra(EXTRA_NAME)
        supportActionBar?.title = barTitle

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgReceived: ImageView = findViewById(R.id.img_item_photo_received)
        val tvReceived: TextView = findViewById(R.id.tv_item_name_received)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_buku)

        //val btnVideo: Button = findViewById(R.id.btn_pesan_buku)
        //btnVideo.setOnClickListener(this)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(E_DETAIL)
        val photo = intent.getIntExtra(EXTRA_IMG, 0)

        val textName = "$name"
        tvReceived.text = textName

        val textDetail = "$detail"
        tvDetailReceived.text = textDetail

        // set recycler view
        rv_bukuKecil = findViewById(R.id.rv_bukuKecil)
        rv_bukuKecil.setHasFixedSize(true)

        listBukuKecil.addAll(DataBukuKecilBM.listBukuKecilBM)
        showRecyclerBukuKecil()

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(350, 350))
            .into(imgReceived)
    }

    private fun showRecyclerBukuKecil(){
        rv_bukuKecil.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val adapterBukuKecil = AdapterBukuKecil(listBukuKecil)
        rv_bukuKecil.adapter = adapterBukuKecil
    }

    override fun onClick(v: View?) {
        val video =
            "https://www.youtube.com/watch?v=Gl2uR-FfDes&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=2&ab_channel=FelixSiauwFelixSiauwVerified"
        val openVideo = Intent(Intent.ACTION_VIEW, Uri.parse(video))
        startActivity(openVideo)
    }
}