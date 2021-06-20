package com.example.renewbaitulmaqdis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class AboutMe : AppCompatActivity() {

    private var title: String = "About Me"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        setActionBarTitle(title)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
                startActivity(Intent(this@AboutMe, MainActivity::class.java))
            }
            R.id.action_about_me -> {

            }
        }
    }
    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }
}