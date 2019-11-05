package br.com.moises.myapplicationjosehenrique

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonagemDAO {

    @Query("SELECT * FROM personagens WHERE :id")
    fun getById(id: Long): Personagem?

    @Query("SELECT * FROM personagens")
    fun findAll(): List<Personagem>

    @Insert
    fun insert(personagem: Personagem)

    @Delete
    fun delete(personagem: Personagem)

}