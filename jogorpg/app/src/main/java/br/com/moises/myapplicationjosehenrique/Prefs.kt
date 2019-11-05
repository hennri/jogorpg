package br.com.moises.myapplicationjosehenrique

import android.content.SharedPreferences
import br.com.fernandosousa.lmsapp.LMSApplication

object Prefs {

    private fun prefs():SharedPreferences{

        val contexto =
            LMSApplication.getInstance().applicationContext

        return contexto.getSharedPreferences("LMS", 0)
    }

    fun setBoolean(flag: String, valor: Boolean){

        prefs().edit().putBoolean(flag,valor).apply()
    }

    fun setString(flag: String, valor: String){

        prefs().edit().putString(flag,valor).apply()
    }

    fun getBoolean(flag: String): Boolean{

        return prefs().getBoolean(flag, false)
    }

    fun getString(flag: String): String{

        return prefs().getString(flag, "")
    }
}
