package com.example.renewbaitulmaqdis

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdapterBaitulMaqdis.OnItemClickListener{

    private lateinit var rvBM: RecyclerView
    //private lateinit var button: Button
    private var list: ArrayList<BaitulMaqdis> = arrayListOf()
    private var title = "Baitul Maqdis"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBM = findViewById(R.id.rv_bm)
        rvBM.setHasFixedSize(true)

        /* ini NPE karena di activity main gak ada button. button itu di rv_bm

        button = findViewById(R.id.btn_detail)
        button.setOnClickListener {
            button.isSelected = !button.isSelected

        }*/


        // to add data from object to list
        list.addAll(DataBaitulMaqdis.listData)

        showRecyclerList()
        setActionBarTitle(title)

    }
    override fun setOnItemClicked(data: BaitulMaqdis, position: Int) {
        setPosition(data, position)
    }

    override fun setOnLinkClicked(data: BaitulMaqdis) {
        val dataLink = Intent(Intent.ACTION_VIEW, Uri.parse(data.links))
        startActivity(dataLink)
    }

    private fun showRecyclerList() {
        rvBM.layoutManager = LinearLayoutManager(this)
        val bmAdapter = AdapterBaitulMaqdis(this, list, this)
        rvBM.adapter = bmAdapter
    }

    private fun setPosition(data: BaitulMaqdis, position: Int){
        val bm = list[position]
        when (position) {
            0 -> {
                val bukuBM = Intent(this@MainActivity, BukuBaitulMaqdis::class.java)
                bukuBM.putExtra(BukuBaitulMaqdis.EXTRA_NAME, bm.name)
                bukuBM.putExtra(BukuBaitulMaqdis.EXTRA_IMG, bm.photo)
                bukuBM.putExtra(BukuBaitulMaqdis.E_DETAIL, bm.detail)
                startActivity(bukuBM)
            }
            1 -> {
                val bukuEmasBM = Intent(this@MainActivity, BukuEmasBaitulMaqdis::class.java)
                bukuEmasBM.putExtra(BukuEmasBaitulMaqdis.EXTRA_NAME, bm.name)
                bukuEmasBM.putExtra(BukuEmasBaitulMaqdis.EXTRA_IMG, bm.photo)
                bukuEmasBM.putExtra(BukuEmasBaitulMaqdis.E_DETAIL, bm.detail)
                startActivity(bukuEmasBM)
            }
            9 -> {
                val donasi = Intent(this@MainActivity, LinkDonasi::class.java)
                donasi.putExtra(LinkDonasi.EXTRA_NAME,bm.name)
                startActivity(donasi)
            }
            else -> {
                val detailBM = Intent(this@MainActivity, DetailBaitulMaqdis::class.java)
                detailBM.putExtra(DetailBaitulMaqdis.EXTRA_NAME, bm.name)
                detailBM.putExtra(DetailBaitulMaqdis.EXTRA_IMG, bm.photo)
                detailBM.putExtra(DetailBaitulMaqdis.E_DETAIL, bm.detail)
                startActivity(detailBM)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_Home -> {

            }
            R.id.action_about_me -> {
                startActivity(Intent(this@MainActivity, AboutMe::class.java))
            }
        }
    }
    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

}