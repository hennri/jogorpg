package br.com.moises.myapplicationjosehenrique

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PersonagemAdapter(
    val personagem: List<Personagem>,
    val onClick: (Personagem) -> Unit
): RecyclerView.Adapter<PersonagemAdapter.PersonagensViewHolder>()

{

    class PersonagensViewHolder(view: View):
        RecyclerView.ViewHolder(view){

        val card_nome: TextView
        val card_img: ImageView
        val card_view: CardView

        init {

            card_nome = view.findViewById<TextView>(R.id.card_nome)

            card_img = view.findViewById<ImageView>(R.id.card_img)

            card_view = view.findViewById<CardView>(R.id.card_personagem)
        }

    }

    override fun getItemCount() =  this.personagem.size
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PersonagensViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_personagem, parent, false)

        return PersonagensViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonagensViewHolder, posicao: Int) {

        val context = holder.itemView.context

        val personagens = personagem[posicao]

        holder.card_nome.text = personagens.nome_personagem

        Picasso.with(context).load(personagens.foto).into(holder.card_img,object : com.squareup.picasso.Callback{
            override fun onSuccess() {

            }

            override fun onError() {

            }
        })

        holder.itemView.setOnClickListener{onClick(personagens)}

    }

}