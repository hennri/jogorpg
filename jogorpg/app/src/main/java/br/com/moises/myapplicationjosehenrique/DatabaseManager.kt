package br.com.moises.myapplicationjosehenrique

import android.provider.DocumentsContract
import androidx.room.Room
import br.com.fernandosousa.lmsapp.LMSApplication

object DatabaseManager {

    private var dbInstance : LMSDatabase

    init {
        var contexto =
            LMSApplication.getInstance().applicationContext

        dbInstance = Room.databaseBuilder(
            contexto,
            LMSDatabase::class.java,
            "LMS.sqlite"
        ).build()
    }

    fun getPersonagemDAO(): PersonagemDAO{
        return dbInstance.personagemDao()
    }
}