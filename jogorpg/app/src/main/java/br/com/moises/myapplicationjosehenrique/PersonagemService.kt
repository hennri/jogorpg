package br.com.moises.myapplicationjosehenrique

import android.content.Context
import android.util.Log
import br.com.fernandosousa.lmsapp.HttpHelper
import br.com.fernandosousa.lmsapp.Response
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object PersonagemService {

    var host = "https://fesousa.pythonanywhere.com"
    var TAG = "WS_RpgMonstros"

    fun getPersonagens(context: Context): List<Personagem>{

        return DatabaseManager.getPersonagemDAO().findAll()
    }

    fun save(personagem: Personagem): Response{
        DatabaseManager.getPersonagemDAO().insert(personagem)
        return Response("OK", "OK")
    }

    fun delet(personagem: Personagem): Response{
        DatabaseManager.getPersonagemDAO().delete(personagem)
        return Response("OK", "OK")
    }

    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }


}