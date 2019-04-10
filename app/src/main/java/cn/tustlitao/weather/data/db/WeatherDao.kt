package cn.tustlitao.weather.data.db

import cn.tustlitao.weather.data.model.weather.Weather
import cn.tustlitao.weather.util.WeatherPreference
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class WeatherDao @Inject constructor() {

    private var weatherStorage: String by WeatherPreference("weather", "")

    private var bingPicStorage: String by WeatherPreference("bing_pic_key", "")

    fun cacheWeatherInfo(weather: Weather?) = weather?.let {
        weatherStorage = Gson().toJson(it)
    }

    fun getCachedWeatherInfo(): Weather? = weatherStorage.let {
        if (!it.isEmpty()) Gson().fromJson(it, Weather::class.java)
        else null
    }

    fun cacheBingPic(bingPic: String?) = bingPic?.let {
        bingPicStorage = bingPic
    }

    fun getCachedBingPic(): String? = bingPicStorage.let {
        if (!it.isEmpty()) bingPicStorage
        else null
    }
}