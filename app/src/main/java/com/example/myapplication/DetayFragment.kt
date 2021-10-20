package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentDetayBinding
import com.example.myapplication.viewModel.AnasayfaViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_bilgisayar_tasarim.*

class DetayFragment : Fragment() {

    private lateinit var tasarim: FragmentDetayBinding
    private lateinit var viewModel: AnasayfaViewModel


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        val detayArg=bundle.detayArg

        tasarim.detayObj=detayArg
        tasarim.buttonSepet.setOnClickListener{

            if(detayArg.sepet_durum !=1){
                viewModel.sepeteEkle(detayArg.id,1)
                Toast.makeText(requireContext(), "Ürün sepete eklendi.",Toast.LENGTH_SHORT).show()  }

            else if(detayArg.sepet_durum==1){
                Toast.makeText(requireContext(),"Ürün zaten sepette.", Toast.LENGTH_SHORT).show()
            }
        }




        var intFiyat=detayArg.fiyat
        var fiyatString=intFiyat.toString()
        tasarim.fiyat=fiyatString
        val url=detayArg.gorsel1
        Picasso.get().load(url).into(tasarim.imageViewDetail1)

        val urliki=detayArg.gorsel2
        Picasso.get().load(urliki).into(tasarim.imageViewDetail2)

        val urluc=detayArg.gorsel3
        Picasso.get().load(urluc).into(tasarim.imageViewDetail3)

        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle:DetayFragmentArgs by navArgs()
        val detayVeri= bundle.detayArg
        tasarim.detayObj=detayVeri




    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
        //dots_indicator.setViewPager2(viewPagerr)
    }

}

