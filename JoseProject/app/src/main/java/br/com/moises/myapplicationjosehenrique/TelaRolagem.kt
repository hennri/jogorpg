package br.com.moises.myapplicationjosehenrique

import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.toolbar.*

class TelaRolagem :  DebugActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prox_telas)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Rolagem"

        //botão voltar para tela de login
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
}