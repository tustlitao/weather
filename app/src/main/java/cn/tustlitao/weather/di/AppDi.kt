package cn.tustlitao.weather.di

import android.app.Application
import cn.tustlitao.weather.WeatherApplication
import cn.tustlitao.weather.data.network.CoolWeatherNetwork
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(panApplication: WeatherApplication)
}


@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideCoolWeatherNetWork(): CoolWeatherNetwork = CoolWeatherNetwork.instance
}
