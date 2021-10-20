package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.databinding.CardBilgisayarTasarimBinding
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.viewModel.AnasayfaViewModel
import com.squareup.picasso.Picasso


class BilgisayarlarAdapter(var mContext: Context, var bilgisayarlarListe:List<Bilgisayarlar> ,var viewModel:AnasayfaViewModel):
    RecyclerView.Adapter<BilgisayarlarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardBilgisayarTasarimBinding) :
        RecyclerView.ViewHolder(cardTasarimBinding.root) {

        var cardTasarim: CardBilgisayarTasarimBinding

        init {
            this.cardTasarim = cardTasarimBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardBilgisayarTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val bilgisayar = bilgisayarlarListe.get(position)
        val tasarim = holder.cardTasarim

        tasarim.tasarimObj=bilgisayar

        holder.cardTasarim.textViewUrunFiyat.text=bilgisayar.fiyat.toString()



        val url = bilgisayar.gorsel1
            Picasso.get().load(url).into(tasarim.imageViewBilgisayarResim)

        tasarim.cardView.setOnClickListener {
            val gecis=UrunlerFragmentDirections.actionUrunlerFragmentToDetayFragment(bilgisayar)
            Navigation.findNavController(it).navigate(gecis)
        }

        tasarim.buttonSepeteEkle.setOnClickListener {
            if (bilgisayar.sepet_durum != 1) {
                viewModel.sepeteEkle(bilgisayar.id, 1)
                Toast.makeText(mContext, "Urun sepete eklendi", Toast.LENGTH_SHORT).show()
            } else if (bilgisayar.sepet_durum == 1) {
                Toast.makeText(mContext, "Urun zaten sepette", Toast.LENGTH_SHORT).show()

        }

        }
    }

        override fun getItemCount(): Int {
            return bilgisayarlarListe.size
        }
    }
