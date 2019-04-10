package cn.tustlitao.weather.data.model.weather

import com.google.gson.annotations.SerializedName

class HeWeather {

    @SerializedName("HeWeather")
    var weather: List<Weather>? = null

}

class Weather {
    var status = ""
    lateinit var basic: Basic
    lateinit var aqi: AQI
    lateinit var now: Now
    lateinit var suggestion: Suggestion
    @SerializedName("daily_forecast")
    lateinit var forecastList: List<Forecast>
}

class AQI {
    lateinit var city: AQICity

    inner class AQICity {
        var aqi = ""
        var pm25  = ""
    }
}

class Basic {
    @SerializedName("city")
    var cityName = ""
    @SerializedName("id")
    var weatherId = ""
    lateinit var update: Update

    inner class Update {
        @SerializedName("loc")
        var updateTime = ""

        fun time() = updateTime.split(" ")[1]
    }
}

class Suggestion {
    @SerializedName("comf")
    lateinit var comfort: Comfort
    @SerializedName("cw")
    lateinit var carWash: CarWash
    lateinit var sport: Sport

    inner class Comfort {
        @SerializedName("txt")
        var info = ""
    }

    inner class CarWash {
        @SerializedName("txt")
        var info = ""
    }

    inner class Sport {
        @SerializedName("txt")
        var info = ""
    }
}

class Now {
    @SerializedName("tmp")
    var temperature = ""
    @SerializedName("cond")
    lateinit var more: More

    fun degree() = "$temperature℃"

    inner class More {
        @SerializedName("txt")
        var info = ""
    }
}

class Forecast {
    var date: String = ""
    @SerializedName("tmp")
    lateinit var temperature: Temperature
    @SerializedName("cond")
    lateinit var more: More

    inner class Temperature {
        var max = ""
        var min = ""
    }

    inner class More {
        @SerializedName("txt_d")
        var info = ""
    }
}