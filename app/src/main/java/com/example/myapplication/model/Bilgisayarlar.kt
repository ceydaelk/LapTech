package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Bilgisayarlar
    (
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("urun_adi")
    @Expose
    var urun_adi: String,

    @SerializedName("gorsel1")
    @Expose var gorsel1: String,

    @SerializedName("gorsel2")
    @Expose var gorsel2: String,

    @SerializedName("gorsel3")
    @Expose var gorsel3: String,

    @SerializedName("fiyat")
    @Expose var fiyat: Float,

    @SerializedName("ssd_kapasite")
    @Expose var ssd_kapasite: String,

    @SerializedName("hdd_kapasite")
    @Expose var hdd_kapasite: String,

    @SerializedName("ram_kapasite")
    @Expose var ram_kapasite: String,

    @SerializedName("dahili_hafiza_tipi")
    @Expose var dahili_hafiza_tipi: String,

    @SerializedName("ekran_boyut")
    @Expose var ekran_boyutu: String,

    @SerializedName("ekran_cozunurluk")
    @Expose var ekran_cozunurluk: String,

    @SerializedName("islemci")
    @Expose var islemci: String,

    @SerializedName("indirim_durum")
    @Expose var indirim_durum: Int,

    @SerializedName("sepet_durum")
    @Expose var sepet_durum: Int,


):Serializable{
}