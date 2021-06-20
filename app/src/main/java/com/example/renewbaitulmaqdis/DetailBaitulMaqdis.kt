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

class DetailBaitulMaqdis : AppCompatActivity(), View.OnClickListener {

    //private lateinit var data: Data
    private lateinit var rv_bukuKecil: RecyclerView
    private var listBukuKecil: ArrayList<BukuKecilBM> = arrayListOf()

    companion object{
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_NAME = "extra_name"
        const val E_DETAIL = "e_detail"
    }
    //private var title: String = "Bebaskan Baitul Maqdis"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_baitul_maqdis)

        val barTitle = intent.getStringExtra(EXTRA_NAME)
        supportActionBar?.title = barTitle

        // set back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgReceived: ImageView = findViewById(R.id.img_item_photo_received)
        val tvReceived: TextView = findViewById(R.id.tv_item_name_received)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_detail_received)

        //val btnVideo: Button = findViewById(R.id.btn_video)
        //btnVideo.setOnClickListener(this)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(E_DETAIL)
        val photo = intent.getIntExtra(EXTRA_IMG,0)

        val textName = "$name"
        tvReceived.text = textName

        val textDetail = "$detail"
        tvDetailReceived.text = textDetail




        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(350,350))
            .into(imgReceived)
    }


    val dataLinks = listOf(
        //"https://www.institutalaqsha.com/buku-kecil-baitul-maqdis",
        //"https://www.institutalaqsha.com/bukuemasbaitulmaqdis",
        "https://www.youtube.com/watch?v=Gl2uR-FfDes&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=2&t=1s",
        "https://www.youtube.com/watch?v=Urc7hXeIKlk&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=3&ab_channel=FelixSiauwFelixSiauwVerified",
        "https://www.youtube.com/watch?v=3xsHRiTZI-w&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=4&ab_channel=FelixSiauwFelixSiauwVerified",
        "https://www.youtube.com/watch?v=S2NFwHsjNWQ&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=5&ab_channel=FelixSiauwFelixSiauwVerified",
        "https://www.youtube.com/watch?v=XO4EqYRYKaQ&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=6&ab_channel=FelixSiauwFelixSiauwVerified",
        "https://www.youtube.com/watch?v=p-9AGQvxXno&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=7&ab_channel=FelixSiauwFelixSiauwVerified",
        "https://www.youtube.com/watch?v=EWn21K-djw0&t=750s&ab_channel=FelixSiauwFelixSiauwVerified"
        //, "ff"
    )
    override fun onClick(v: View?) {
        //val video = "https://www.youtube.com/watch?v=Gl2uR-FfDes&list=PLrHLKmQIFlCFolQPGPwvnF4LarJNTlkUq&index=2&ab_channel=FelixSiauwFelixSiauwVerified"
        //val data = RestApiData().fetchLink()
        //val selectedData = data[0]

        //val linkData = RestApiData().fetchLink()
        //val selectedLinkData = DataLinkProcess().getDataLink()


        //val getData = data.getData(2)

        //val arraylistData = RestApiData().fetchLink()
        //val selectedData = DataProcess(arraylistData).getDataWhereID(1)

        //val openVideo = Intent(Intent.ACTION_VIEW, Uri.parse(getData.link))
        //startActivity(openVideo)
    }
    /*private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }*/


}