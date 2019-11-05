package br.com.moises.myapplicationjosehenrique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var imgLogin = findViewById<ImageView>(R.id.imageView)
        imgLogin.setImageResource(R.drawable.caveirinha)
        imageView.setImageResource(R.drawable.caveirinha)


        btnLogin.setOnClickListener {
            //var text_user = campo_user.text.toString()
            onClickLogin()

        }

        txtBoxEmail.setText(Prefs.getString("lembrarNome"))
        txtBoxPassword.setText(Prefs.getString("lembrarSenha"))
        checkBox.isChecked = Prefs.getBoolean(("checkLembrar"))

    }

    fun onClickLogin() {
        var texto_usuario = txtBoxEmail.text.toString()
        val texto_senha = txtBoxPassword.text.toString()

        val valorCheck = checkBox.isChecked
        Prefs.setBoolean("checkBoxLogin", valorCheck)
        if (valorCheck){
            Prefs.setString("lembrarNome", texto_usuario)
            Prefs.setString("lembrarSenha", texto_senha)
        } else {
            Prefs.setString("lembrarNome","")
            Prefs.setString("lembrarSenha", "")
        }


        if (texto_usuario == "aluno" && texto_senha == "impacta") {

            Toast.makeText(this, "Bem vindo: $texto_usuario", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, TelaInicialActivity::class.java)

            intent.putExtra("nome_usuario", texto_usuario)
            intent.putExtra("numero", 10)
            //val params = Bundle()
            //params.putString("nome_usuario", texto_usuario)
            // params.putInt("numnero",10)
            //intent.putExtras(params)
            startActivity(intent)
        }else{
           Toast.makeText(this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show()
        }
    }
}
