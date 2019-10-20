package br.com.moises.myapplicationjosehenrique

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DisciplinaAdapter(
    val disciplinas: List<Disciplina>,
    val onClick: (Disciplina) -> Unit
): RecyclerView.Adapter<DisciplinaAdapter.DisciplinasViewHolder>()

{

    class DisciplinasViewHolder(view: View):
        RecyclerView.ViewHolder(view){

        val card_nome: TextView
        val card_img: ImageView
        val card_view: CardView

       init {

           card_nome = view.findViewById<TextView>(R.id.card_nome)

           card_img = view.findViewById<ImageView>(R.id.card_img)

           card_view = view.findViewById<CardView>(R.id.card_disciplinas)
       }

    }

    override fun getItemCount() =  this.disciplinas.size
    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int): DisciplinasViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_disciplina, parent, false)

        return DisciplinasViewHolder(view)
    }

    override fun onBindViewHolder(holder: DisciplinasViewHolder, posicao: Int) {

        val context = holder.itemView.context

        val disciplina = disciplinas[posicao]

        holder.card_nome.text = disciplina.nome

        Picasso.with(context).load(disciplina.foto).into(holder.card_img,object : com.squareup.picasso.Callback{
            override fun onSuccess() {

            }

            override fun onError() {

            }
        })

        holder.itemView.setOnClickListener{onClick(disciplina)}

    }

}