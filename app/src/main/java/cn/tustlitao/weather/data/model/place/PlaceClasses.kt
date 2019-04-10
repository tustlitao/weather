package cn.tustlitao.weather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

data class Province(
    @SerializedName("name") val provinceName: String,
    @SerializedName("id") val provinceCode: Int,
    @Transient val id: Int = 0
): LitePalSupport()

data class City (
    @SerializedName("name") val cityName: String,
    @SerializedName("id") val cityCode: Int,
    @Transient val id: Int = 0,
    var provinceId: Int = 0
): LitePalSupport()

data class County(
    @SerializedName("name") val countyName: String,
    @SerializedName("weather_id") val weatherId: String,
    @Transient val id: Int = 0,
    var cityId: Int = 0
): LitePalSupport()

