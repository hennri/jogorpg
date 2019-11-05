package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class GirarDadoMonstro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_girar_dado_monstro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Girar dado")


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickBotao() {
        val intent = Intent(this, Personagem::class.java)
        startActivity(intent)
    }
}

