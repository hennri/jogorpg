package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(),
    NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        var n = args?.getInt("numero")

        //texto_tela_inicial.setText("Olá $nome")

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Personagens"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerPersonagens?.layoutManager= LinearLayoutManager(this)
        recyclerPersonagens?.itemAnimator = DefaultItemAnimator()
        recyclerPersonagens.setHasFixedSize(true)

    }

    var personagens = listOf<Personagem>()

    override fun onResume() {
        super.onResume()
        taskPersonagen()

        //Personagens = PersonagemService.getPersonagens(this)
        //recyclerPersonagens?.adapter = PersonagemAdapter(Personagens){onClickPersonagem(it)}
    }

    fun taskPersonagen() {
        Thread {
            this.personagens = PersonagemService.getPersonagens(this)

            runOnUiThread {
                //atualiza lista
                recyclerPersonagens?.adapter = PersonagemAdapter(personagens) {
                    onClickPersonagem(it)
                }
            }
        }.start()
    }

    fun onClickPersonagem(personagem: Personagem){
        Toast.makeText(this,"Clicou em personagem ${personagem.nome_personagem}", Toast.LENGTH_SHORT).show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou em atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou em configurações", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em buscar", Toast.LENGTH_SHORT).show()
        }else if(id == R.id.action_adicionar){
            Toast.makeText(this,"Clicou em adicionar", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,AdicionarActivity::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_personagens -> {
                Toast.makeText(
                    this,
                    "Clicou em Personagem",
                    Toast.LENGTH_SHORT
                ).show()
            }
            R.id.nav_forum -> {
                Toast.makeText(
                    this,
                    "Clicou em fórum",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, ForumActivity::class.java)
                startActivity(intent)
            }

        }
        layout_menuLateral.closeDrawer(GravityCompat.START)
        return true

    }

    private fun configuraMenuLateral() {

        var toogle = ActionBarDrawerToggle(
            this,
            layout_menuLateral,
            toolbar,
            R.string.open,
            R.string.close
        )
        layout_menuLateral!!.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }
}

