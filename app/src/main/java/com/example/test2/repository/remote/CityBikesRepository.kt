package com.example.test2.repository.remote

import com.example.test2.model.Network

class CityBikesRepository(private val bikeInterfaceApi: CityBikesInterfaceApi) {

    fun getBikeStations(): List<Network> {
        val result = bikeInterfaceApi.getNetworks().execute()
        return result.body()?.networks ?: emptyList()
    }
}