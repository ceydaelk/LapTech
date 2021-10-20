package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.IndirimFragmentDirections
import com.example.myapplication.UrunlerFragmentDirections
import com.example.myapplication.databinding.CardBilgisayarTasarimBinding
import com.example.myapplication.databinding.IndirimCardBinding
import com.example.myapplication.databinding.SepetCardBinding
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.viewModel.AnasayfaViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.indirim_card.view.*
import kotlinx.android.synthetic.main.sepet_card.view.*

class IndirimAdapter(var mContext: Context, var bilgisayarlarListe:List<Bilgisayarlar>, var viewModel: AnasayfaViewModel):
    RecyclerView.Adapter<IndirimAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(indirimfragmentBinding: IndirimCardBinding) :
        RecyclerView.ViewHolder(indirimfragmentBinding.root){

            var cardTasarim: IndirimCardBinding
            init {
                this.cardTasarim=indirimfragmentBinding

            }

        }

    override fun getItemCount(): Int {
        return bilgisayarlarListe.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = IndirimCardBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val bilgisayar = bilgisayarlarListe.get(position)
        val tasarim = holder.cardTasarim

        tasarim.indirimObj=bilgisayar

        tasarim.cardView.indirimFiyat.text=bilgisayar.fiyat.toString()

        val url = bilgisayar.gorsel1
        Picasso.get().load(url).into(tasarim.indirimResim)

        tasarim.cardView.setOnClickListener {
            val gecis=IndirimFragmentDirections.indirimtoDetail(bilgisayar)
            Navigation.findNavController(it).navigate(gecis)
        }

        tasarim.indirimButton.setOnClickListener {
            if (bilgisayar.sepet_durum != 1) {
                viewModel.sepeteEkle(bilgisayar.id, 1)
                Toast.makeText(mContext, "Urun sepete eklendi", Toast.LENGTH_SHORT).show()
            } else if (bilgisayar.sepet_durum == 1) {
                Toast.makeText(mContext, "Urun zaten sepette", Toast.LENGTH_SHORT).show()

            }

        }
    }
}





