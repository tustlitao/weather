package cn.tustlitao.weather.ui

import androidx.lifecycle.ViewModel
import cn.tustlitao.weather.data.WeatherRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: WeatherRepository): ViewModel() {

    fun isWeatherCached() = repository.isWeatherCached()
}