package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.adapter.BilgisayarlarAdapter
import com.example.myapplication.databinding.FragmentUrunlerBinding
import com.example.myapplication.viewModel.AnasayfaViewModel
import kotlinx.android.synthetic.main.card_bilgisayar_tasarim.*

class UrunlerFragment : Fragment() {

    private lateinit var tasarim:FragmentUrunlerBinding
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var adapter: BilgisayarlarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_urunler, container, false)



        viewModel.bilgisayarlarliste.observe(viewLifecycleOwner, { list ->
            adapter = BilgisayarlarAdapter(requireContext(), list,viewModel)
            tasarim.adapterFragment = adapter
            //viewModel.loadBooks()
        })

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel


    }
    }
