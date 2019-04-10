package cn.tustlitao.weather.di

import cn.tustlitao.weather.di.annotation.ActivityScope
import cn.tustlitao.weather.di.annotation.FragmentQualifier
import cn.tustlitao.weather.ui.area.ChooseAreaFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Module
abstract class MainFragmentBindModule {

    @ContributesAndroidInjector
    abstract fun contributeChooseAreaFragment(): ChooseAreaFragment
}

@Module
abstract class WeatherFragmentBindModule {

    @ContributesAndroidInjector
    abstract fun contributeChooseAreaFragment(): ChooseAreaFragment
}


