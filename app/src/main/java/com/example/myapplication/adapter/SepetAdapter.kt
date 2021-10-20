package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.UrunlerFragmentDirections
import com.example.myapplication.databinding.CardBilgisayarTasarimBinding
import com.example.myapplication.databinding.FragmentSepetBinding
import com.example.myapplication.databinding.SepetCardBinding
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.viewModel.AnasayfaViewModel
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var bilgisayarlarListe:List<Bilgisayarlar>, var viewModel: AnasayfaViewModel):RecyclerView.Adapter<SepetAdapter.TasarimTutucu>() {

    inner class TasarimTutucu(cardSepetBinding: SepetCardBinding):RecyclerView.ViewHolder(cardSepetBinding.root){
        var cardTasarim: SepetCardBinding

        init {
            this.cardTasarim = cardSepetBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardBinding.inflate(layoutInflater, parent, false)
        return TasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: TasarimTutucu, position: Int) {
        val bilgisayar = bilgisayarlarListe.get(position)
        val tasarim = holder.cardTasarim

        tasarim.sepetObj=bilgisayar

        holder.cardTasarim.sepetFiyat.text = bilgisayar.fiyat.toString()

        val url = bilgisayar.gorsel1
        Picasso.get().load(url).into(tasarim.sepetResim)

        holder.cardTasarim.sepetButon.setOnClickListener {
            if (bilgisayar.sepet_durum == 1) {
                viewModel.sepettenCikar(bilgisayar.id, 0)
                Toast.makeText(mContext, "Urun sepetten cıkartıldı", Toast.LENGTH_SHORT).show()
            }
            else{}


        }
    }

    override fun getItemCount(): Int {
       return bilgisayarlarListe.size
    }

}