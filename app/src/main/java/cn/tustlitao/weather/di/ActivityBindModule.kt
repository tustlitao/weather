package cn.tustlitao.weather.di

import cn.tustlitao.weather.di.annotation.ActivityScope
import cn.tustlitao.weather.ui.MainActivity
import cn.tustlitao.weather.ui.area.ChooseAreaFragment
import cn.tustlitao.weather.ui.weather.WeatherActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainFragmentBindModule::class])
    abstract fun mainActivityInjector(): MainActivity


    @ActivityScope
    @ContributesAndroidInjector(modules = [WeatherFragmentBindModule::class])
    abstract fun weatherActivityInjector(): WeatherActivity
}


