package com.example.myapplication.retrofit


import com.example.myapplication.model.BilgisayarCevap
import com.example.myapplication.model.Bilgisayarlar
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeInterface {

    @GET("bilgisayarlar/bilgisayarlar.php")
    fun tumKitaplar(): Call<BilgisayarCevap>

    @POST("bilgisayarlar.php")
    @FormUrlEncoded
    fun getAllItems(@Field("kullanici")kullanici: String): Call<BilgisayarCevap>

    @POST("bilgisayarlar_indirimli.php")
    @FormUrlEncoded
    fun indirimYap(
        @Field("id")id:Int,
        @Field("urun_indirimli_mi")urun_indirimli_mi:String):Call<BilgisayarCevap>

    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun bilgisayarEkle(@Field("kullanici") kullanici: String,
                  @Field("urun_adi") urun_adi:String,
                  @Field("fiyat") fiyat:Float,
                  @Field("urun_gorsel_url") gorsel1:String):Call<BilgisayarCevap>


    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun sepetDurum(
        @Field("id") id: Int,
        @Field("sepet_durum") sepet_durum:Int) :Call<BilgisayarCevap>



}