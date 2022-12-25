package com.example.ak7mtprojekt.networkdata

import com.example.ak7mtprojekt.localdata.DBWeatherInfo
import com.example.ak7mtprojekt.uidata.WeatherInfo
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

//vygenerováno na https://json2kt.com/
data class NetWeatherInfo(
    /*val id: Int? = null,
    val cityName: String,
    val cityState: String,
    val description: String?,
    val temperatureC: Int,
    val dateOfFetch: Date,
    val lat: Double,
    val lon: Double*/
    var coord      : Coord?             = Coord(),
    var weather    : ArrayList<Weather> = arrayListOf(),
    var base       : String?            = null,
    var main       : Main?              = Main(),
    var visibility : Int?               = null,
    var wind       : Wind?              = Wind(),
    var clouds     : Clouds?            = Clouds(),
    var dt         : Int?               = null,
    var sys        : Sys?               = Sys(),
    var timezone   : Int?               = null,
    var id         : Int?               = null,
    var name       : String?            = null,
    var cod        : Int?               = null
)

data class Coord (

    var lon : Double? = null,
    var lat : Double? = null

)

data class Weather (

    var id          : Int?    = null,
    var main        : String? = null,
    var description : String? = null,
    var icon        : String? = null

)

data class Main (

    var temp      : Double? = null,
    var feels_like : Double? = null,
    var temp_min   : Double? = null,
    var temp_max   : Double? = null,
    var pressure  : Int?    = null,
    var humidity  : Int?    = null

)

data class Wind (

    var speed : Double? = null,
    var deg   : Int?    = null

)

data class Clouds (

    var all : Int? = null

)

data class Sys (

    var type    : Int?    = null,
    var id      : Int?    = null,
    var country : String? = null,
    var sunrise : Int?    = null,
    var sunset  : Int?    = null

)

data class NetWeatherInfoContainer(
    val videos: List<NetWeatherInfo>
)

// převod api modelu do db modelu
fun List<NetWeatherInfo>.asDatabaseModel(): List<DBWeatherInfo> {
    return map {
        DBWeatherInfo(
            id = it.id,
            cityName = it.name,
            cityState = it.sys?.country,
            description = it.weather.firstOrNull()?.description,
            temperatureC = it.main?.temp,
            lat = it.coord?.lat,
            lon = it.coord?.lon
        )
    }
}

/*fun List<NetWeatherInfo>.asDomainModel(): List<WeatherInfo> {
    return map {
        WeatherInfo(
            id = it.id,
            cityName = it.cityName,
            cityState = it.cityState,
            description = it.description,
            temperatureC = it.temperatureC,
            dateOfFetch = it.dateOfFetch,
            lat = it.lat,
            lon = it.lon
        )
    }
}*/