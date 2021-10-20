package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.repo.BilgisayarlarRepo

class AnasayfaViewModel : ViewModel(){
    private val brepo = BilgisayarlarRepo()
    val bilgisayarlarliste: MutableLiveData<List<Bilgisayarlar>>
    //var priceResult = MutableLiveData<String>()

    init {
        loadBilgisayarlar()
        bilgisayarlarliste = brepo.bilgisayarlariGetir()
        //priceResult = MutableLiveData<String>("0")
        //priceResult=bringPrice()
    }
//    fun sepeteEkle(id: Int,sepet_durum:Int){
//        brepo.
//    }

    fun loadBilgisayarlar(){
        Log.e("calisiyormu","calisiyor")
        brepo.getBilgisayarlar("ceydaelik")


    }
    fun sepeteEkle(id: Int,sepet_durum:Int){
        brepo.sepetEkle(id,1)
        Log.e("sepet durum",sepet_durum.toString())
    }

    fun sepettenCikar(id: Int,sepet_durum:Int){
        brepo.sepettenCikar(id,0)
        Log.e("sepet durum",sepet_durum.toString())
    }


}
