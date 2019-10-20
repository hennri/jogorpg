package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
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

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerDisciplinas?.layoutManager= LinearLayoutManager(this)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas.setHasFixedSize(true)

    }

    var disciplinas = listOf<Disciplina>()

    override fun onResume() {
        super.onResume()

        disciplinas = DisciplinaService.getDisciplinas(this)
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas){onClickDisciplina(it)}
    }

    fun onClickDisciplina(disciplina: Disciplina){
        Toast.makeText(this,"Clicou em monstros ${disciplina.nome}", Toast.LENGTH_SHORT).show()
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
            val intent = Intent(this, Configuracao::class.java)
            startActivity(intent)
        } else if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em buscar", Toast.LENGTH_SHORT).show()
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                Toast.makeText(
                    this,
                    "Clicou em Girar dado",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this,GirarDadoMonstro::class.java)
                startActivity(intent)
            }
            R.id.nav_forum -> {
                Toast.makeText(
                    this,
                    "Clicou em ajuda",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, ForumActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_sair ->{
                Toast.makeText(this,"Sair", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
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

