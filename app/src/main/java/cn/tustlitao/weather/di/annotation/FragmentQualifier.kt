package cn.tustlitao.weather.di.annotation
import javax.inject.Qualifier


@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentQualifier (val value: String = "")
