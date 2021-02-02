package com.example.test2.model


/**
 *   "networks": [
{
"company": [
"ЗАО «СитиБайк»"
],
"href": "/v2/networks/velobike-moscow",
"id": "velobike-moscow",
"location": {
"city": "Moscow",
"country": "RU",
"latitude": 55.75,
"longitude": 37.616667
},
"name": "Velobike"
}

 Podriamos usar  @Json(name = "IsOnline")val online: String si no nos gustase el nombre del parametro
 */
data class Location(val city: String, val country: String, val latitude: Double, val longitude: Double)
data class Network(val company: Any, val href: String, val id: String, val name: String, val location: Location)
data class NetworkList(val networks: List<Network>)

