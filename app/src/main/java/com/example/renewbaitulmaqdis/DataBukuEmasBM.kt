package com.example.renewbaitulmaqdis

object DataBukuEmasBM {
    private val imgBukuBM = arrayOf(
        R.drawable.bebm1,
        R.drawable.bebm2
    )

    val listBukuEmasBM: ArrayList<BukuEmasBM>
        get() {
            val lisBukuEmas = arrayListOf<BukuEmasBM>()
            for (bkPosisi in imgBukuBM.indices){
                val bukuEmas = BukuEmasBM()
                bukuEmas.bukuEmasBM = imgBukuBM[bkPosisi]
                lisBukuEmas.add(bukuEmas)
            }
            return lisBukuEmas
        }
}