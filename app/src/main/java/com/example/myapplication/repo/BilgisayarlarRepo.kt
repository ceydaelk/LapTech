package com.example.myapplication.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.BilgisayarCevap
import com.example.myapplication.model.Bilgisayarlar
import com.example.myapplication.model.CRUDAnswer
import com.example.myapplication.retrofit.ApiUtils
import com.example.myapplication.retrofit.HomeInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BilgisayarlarRepo {

    private val bdaoi: HomeInterface
    private val bilgisayarlarListe= MutableLiveData<List<Bilgisayarlar>>()

    init{
        bdaoi= ApiUtils.getHomeInterface()
        //bilgisayarlarListe = MutableLiveData()


    }
    fun bilgisayarlariGetir():MutableLiveData<List<Bilgisayarlar>> {
        return bilgisayarlarListe
    }
    fun getBilgisayarlar(kullanici: String){
        bdaoi.getAllItems("ceydaelik").enqueue(object : Callback<BilgisayarCevap> {
            override fun onResponse(call: Call<BilgisayarCevap>?, response: Response<BilgisayarCevap>) {

                val list: List<Bilgisayarlar> = response.body()!!.bilgisayarlar
                bilgisayarlarListe.value = list

            }
            override fun onFailure(call: Call<BilgisayarCevap>?, t: Throwable?) {
                Log.e("Error", t.toString())
            }
        })
    }

    fun bilgisayarEkle(kullanici: String,urun_adi:String,fiyat:Float, urun_gorsel_url:String){
        bdaoi.bilgisayarEkle(kullanici ,urun_adi,fiyat,urun_gorsel_url).enqueue(object: Callback<BilgisayarCevap> {
            override fun onResponse(call: Call<BilgisayarCevap>?, response: Response<BilgisayarCevap>) {
                Log.e("success", response.body().toString())
                Log.e("basarili","mission complete")
            }

            override fun onFailure(call: Call<BilgisayarCevap>?, t: Throwable?) {
                Log.e("fail",t.toString()!!)
            }
        })}

            fun indirimYap(id: Int, urun_indirimli_mi: String){
                bdaoi.indirimYap(id,urun_indirimli_mi).enqueue(object: Callback<BilgisayarCevap> {
                    override fun onResponse(call: Call<BilgisayarCevap>?, response: Response<BilgisayarCevap>?) {
                        Log.e("yeni durum", id.toString()+ "  "+ urun_indirimli_mi.toString())


                    }
                    override fun onFailure(call: Call<BilgisayarCevap>?, t: Throwable?) {
                        Log.e("oldu mu","oldu")
                    }

                })
            }

        fun sepetEkle(id: Int,sepet_durum:Int){
            bdaoi.sepetDurum(id, sepet_durum).enqueue(object :Callback<BilgisayarCevap>{
                override fun onResponse(call: Call<BilgisayarCevap>?, response: Response<BilgisayarCevap>?) {
                    Log.e("yeni durum", id.toString()+ "  "+ sepet_durum.toString())


                }

                override fun onFailure(call: Call<BilgisayarCevap>?, t: Throwable?) {
                    Log.e("fail","olmadı ")
                }


            })
        }

        fun sepettenCikar(id: Int,sepet_durum:Int){
            bdaoi.sepetDurum(id, sepet_durum).enqueue(object :Callback<BilgisayarCevap>{
                override fun onResponse(call: Call<BilgisayarCevap>?, response: Response<BilgisayarCevap>?) {
                    Log.e("yeni durum", id.toString()+ "  "+ sepet_durum.toString())


                }


                override fun onFailure(call: Call<BilgisayarCevap>?, t: Throwable?) {
                    Log.e("fail","olmaz ")
                }


            })
        }





}