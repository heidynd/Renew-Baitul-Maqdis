package com.example.renewbaitulmaqdis

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class LinkDonasi : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_donasi)

        val btnAlaqsa: Button = findViewById(R.id.button_donasi_aqsa)
        btnAlaqsa.setOnClickListener(this)

        val btnNPC: Button = findViewById(R.id.button_donasi_npc)
        btnNPC.setOnClickListener(this)

        val barTitle = intent.getStringExtra(EXTRA_NAME)
        supportActionBar?.title = barTitle

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button_donasi_aqsa -> {
                val alAqsa = "http://sahabatalaqsha.com/nws/"
                val keAlaqsa = Intent(Intent.ACTION_VIEW, Uri.parse(alAqsa))
                startActivity(keAlaqsa)
            }
            R.id.button_donasi_npc -> {
                val npc = "https://donasi.npc.or.id/"
                val keNPC = Intent(Intent.ACTION_VIEW, Uri.parse(npc))
                startActivity(keNPC)
            }
        }
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }
}