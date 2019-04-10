package cn.tustlitao.weather.data.db

import cn.tustlitao.weather.data.model.place.City
import cn.tustlitao.weather.data.model.place.County
import cn.tustlitao.weather.data.model.place.Province
import org.litepal.LitePal
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PlaceDao @Inject constructor(){

    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId:Int): MutableList<City> = LitePal.where("provinceId = ?", provinceId.toString()).find(City::class.java)

    fun getCountyList(cityId: Int): MutableList<County> = LitePal.where("cityId = ?", cityId.toString()).find(County::class.java)

    fun saveProvinceList(provinceList: List<Province>?) {
        if (provinceList != null && !provinceList.isEmpty()) {
            LitePal.saveAll(provinceList)
        }
    }

    fun saveCityList(cityList: List<City>?) {
        if (cityList != null && !cityList.isEmpty()) {
            LitePal.saveAll(cityList)
        }
    }

    fun saveCountyList(countyList: List<County>?) {
        if (countyList != null && countyList.isNotEmpty()) {
            LitePal.saveAll(countyList)
        }
    }
}