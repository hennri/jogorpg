package br.com.moises.myapplicationjosehenrique

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "personagens")
class Personagem : Serializable{

    @PrimaryKey
    var id:Long = 0
    var nome_personagem = ""
    var classe = ""
    var tribo = ""
    var foto = ""

    override fun toString(): String{
        return super.toString()
    }



}