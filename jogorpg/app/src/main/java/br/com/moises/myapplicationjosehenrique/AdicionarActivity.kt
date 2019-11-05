package br.com.moises.myapplicationjosehenrique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adicionar.*

class AdicionarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        botaSalvar.setOnClickListener(){
            var d = Personagem()
            d.nome_personagem = campo_nome.text.toString()
            d.classe = campo_ementa.text.toString()
            d.tribo = campo_professor.text.toString()
            d.foto = campo_imagem.text.toString()



            Thread{
                PersonagemService.save(d)
                runOnUiThread{
                    finish()
                }
            }.start()
        }

    }
}
