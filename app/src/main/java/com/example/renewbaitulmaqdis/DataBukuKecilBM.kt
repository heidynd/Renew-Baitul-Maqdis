package com.example.renewbaitulmaqdis

object DataBukuKecilBM {
    private val imgBukuBM = arrayOf(
        R.drawable.bkbm1,
        R.drawable.bkbm2
    )

    val listBukuKecilBM: ArrayList<BukuKecilBM>
    get() {
        val lisBukuKecil = arrayListOf<BukuKecilBM>()
        for (bkPosisi in imgBukuBM.indices){
            val bukuKecil = BukuKecilBM()
            bukuKecil.bukuKecilBM = imgBukuBM[bkPosisi]
            lisBukuKecil.add(bukuKecil)
        }
        return lisBukuKecil
    }
}