package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import android.widget.EditText
import android.widget.Button

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var imgLogin = findViewById<ImageView>(R.id.imageView)
        imgLogin.setImageResource(R.drawable.d20)
        imageView.setImageResource(R.drawable.d20)


        btnLogin.setOnClickListener{

            onClickLogin()

        }

        }

        fun onClickLogin(){
            var texto_usuario= txtBoxEmail.text.toString()
            var texto_senha= txtBoxPassword.text.toString()


            //val usuario = findViewById<EditText>(R.id.txtBoxEmail).toString()
            //val senha = findViewById<EditText>(R.id.txtBoxPassword).toString()
            if ( texto_usuario == "aluno" && texto_senha == "impacta"){

                val intent = Intent(this, TelaInicialActivity::class.java)

                intent.putExtra("nome_usuario", texto_usuario)
                intent.putExtra("numero", 10)

                startActivity(intent)


            }else{
                Toast.makeText(this, "Usuário ou senha invalido", Toast.LENGTH_SHORT).show()
            }





        }


}
