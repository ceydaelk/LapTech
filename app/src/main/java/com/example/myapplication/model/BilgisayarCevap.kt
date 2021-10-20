package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BilgisayarCevap(
    @SerializedName("bilgisayarlar")
    @Expose var bilgisayarlar: List<Bilgisayarlar>,
    @SerializedName("success")
    @Expose var success:Int
) {
}