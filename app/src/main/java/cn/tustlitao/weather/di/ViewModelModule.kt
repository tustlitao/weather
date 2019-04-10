package cn.tustlitao.weather.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.tustlitao.weather.WeatherViewModelFactory
import cn.tustlitao.weather.di.annotation.ViewModelKey
import cn.tustlitao.weather.ui.MainViewModel
import cn.tustlitao.weather.ui.area.ChooseAreaViewModel
import cn.tustlitao.weather.ui.weather.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel (mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindWeatherViewModel (weatherViewModel: WeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChooseAreaViewModel::class)
    abstract fun bindChooseAreaViewModel(chooseAreaViewModel: ChooseAreaViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: WeatherViewModelFactory): ViewModelProvider.Factory
}