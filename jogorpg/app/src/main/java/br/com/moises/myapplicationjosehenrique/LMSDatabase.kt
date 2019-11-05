package br.com.moises.myapplicationjosehenrique

import android.provider.DocumentsContract
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Personagem::class), version = 1)
abstract class LMSDatabase : RoomDatabase(){

    abstract fun personagemDao(): PersonagemDAO
}