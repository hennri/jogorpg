package br.com.moises.myapplicationjosehenrique

import android.content.Context

object DisciplinaService {

    fun getDisciplinas(context: Context): List<Disciplina>{
        val disciplinas = mutableListOf<Disciplina>()


        for (i in 1..10){
            val d = Disciplina()
            d.nome = "Monstros $i"
            d.ementa = "Ementa $i"
            d.professor = "Professor $i"
            d.foto = "https://i.pinimg.com/originals/f2/21/87/f221879b5bff9c90115befabdfbbf4f1.jpg"
            disciplinas.add(d)


        }
        return disciplinas
    }


}