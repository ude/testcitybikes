package com.example.test2.repository.remote

import com.example.test2.model.NetworkList
import com.example.test2.model.StationModel
import com.example.test2.model.StationResponse
import com.example.test2.model.StationWrapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object Injection {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.citybik.es/")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                ).build()
            )
        .build()

    fun getApi(): CityBikesInterfaceApi = getRetrofit().create(CityBikesInterfaceApi::class.java)
}





interface CityBikesInterfaceApi {

    @GET("/v2/networks")
    fun getNetworks(): Call<NetworkList>

    @GET("/v2/networks/{network}")
    fun getStations(@Path("network") network: String): Call<StationResponse>
}