package br.com.moises.myapplicationjosehenrique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class Configuracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Configurações")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}


