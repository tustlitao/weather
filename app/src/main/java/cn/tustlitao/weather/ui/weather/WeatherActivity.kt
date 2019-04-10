package cn.tustlitao.weather.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import cn.tustlitao.weather.R
import cn.tustlitao.weather.databinding.ActivityWeatherBinding
import cn.tustlitao.weather.ui.area.ChooseAreaFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.title.*
import qiu.niorgai.StatusBarCompat
import javax.inject.Inject

class WeatherActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel::class.java)}

    private val binding by lazy { DataBindingUtil.setContentView<ActivityWeatherBinding>(this, R.layout.activity_weather)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        StatusBarCompat.translucentStatusBar(this, true)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        viewModel.weatherId = if (viewModel.isWeatherCached()) {
            viewModel.getCachedWeather().basic.weatherId
        } else {
            intent.getStringExtra("weather_id")
        }
        navButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        viewModel.getWeather()

        supportFragmentManager.beginTransaction().replace(R.id.container, ChooseAreaFragment()).commit()

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}
