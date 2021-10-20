package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.myapplication.adapter.SepetAdapter
import com.example.myapplication.databinding.FragmentSepetBinding
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.viewModel.AnasayfaViewModel

class SepetFragment : Fragment() {
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel:AnasayfaViewModel
    private lateinit var sepetAdp:SepetAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)
        return tasarim.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var indirimli_mi=0
        val discountBilgisayarlar=ArrayList<Bilgisayarlar>()
        viewModel.bilgisayarlarliste.observe(viewLifecycleOwner, { discBilgList ->
            val pcDisc=discBilgList
            if(pcDisc !=null){
                for(i in 0 until pcDisc.size){
                    indirimli_mi=pcDisc.get(i).sepet_durum.toInt()


                    if (pcDisc.get(i).sepet_durum ==1){
                        discountBilgisayarlar.add(pcDisc.get(i))
                        sepetAdp = SepetAdapter(requireContext(), discountBilgisayarlar, viewModel)
                        tasarim.sepetAdapter = sepetAdp
                        //tasarim.indicator.setViewPager(tasarim.viewPagerr)



                    }

                }
            }


        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
        //dots_indicator.setViewPager2(viewPagerr)
    }

}