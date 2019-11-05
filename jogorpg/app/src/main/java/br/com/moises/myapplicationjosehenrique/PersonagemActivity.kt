package br.com.moises.myapplicationjosehenrique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_personagem.*
import kotlinx.android.synthetic.main.toolbar.*

class PersonagemActivity : AppCompatActivity() {

    var personagem: Personagem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem)

        // recuperar onjeto de Personagem da Intent
        personagem = intent.getSerializableExtra("personagem") as Personagem

        // configurar título com nome da Personagem e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = personagem?.nome_personagem

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da personagem
        nomePersonagem.text = personagem?.nome_personagem
        Picasso.with(this).load(personagem?.foto).fit().into(imagemPersonagem,

            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
    }
}
