package com.example.myapplication.retrofit

class ApiUtils {

    companion object{
        val BASE_URL:String ="http://wtech.canerture.com/bilgisayarlar/"

        fun getHomeInterface():HomeInterface{

            return RetrofitClient.getClient(BASE_URL).create(HomeInterface::class.java)
        }
    }

}