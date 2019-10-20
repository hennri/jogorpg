package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        var n = args?.getInt("numero")

        texto_tela_inicial.setText("Olá $nome")

        setSupportActionBar(toolbar)

        supportActionBar?.title = "DiceRoller"

        //botão voltar para tela de login
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //botoes para abrir outras telas

        btnListaMonstros.setOnClickListener{
            onClickListaMontros()
        }

        btnMonstro.setOnClickListener{
            onClickMonstro()
        }
        btnRolagem.setOnClickListener{
            onClickRolagem()
        }
    }
    //os botoes do main menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean{
        val id = item?.itemId
        if(id == R.id.action_atualizar){
            Toast.makeText(this,"Clicou em atualizar", Toast.LENGTH_SHORT).show()
        }
        else if(id == R.id.action_config){
            Toast.makeText(this,"Clicou em configurações", Toast.LENGTH_SHORT).show()
        }else if(id == R.id.action_buscar){

            Toast.makeText(this,"Clicou em buscar", Toast.LENGTH_SHORT).show()



        }else if(id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickListaMontros(){
        val intentLM = Intent(this, TelaListaMonstro::class.java)
        startActivity(intentLM)
    }

    fun onClickMonstro(){
        val intentMonstro = Intent(this, TelaMonstro::class.java)
        startActivity(intentMonstro)
    }

    fun onClickRolagem(){
        val intentRolagem = Intent(this, TelaRolagem::class.java)
        startActivity(intentRolagem)

    }

}

