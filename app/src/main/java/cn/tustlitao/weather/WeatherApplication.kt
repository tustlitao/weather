package cn.tustlitao.weather

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import cn.tustlitao.weather.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import org.litepal.LitePal
import javax.inject.Inject

class WeatherApplication: Application(), HasActivityInjector {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()

        context = this

        AppInjector.inject(this)

        //加载litepal
        LitePal.initialize(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}