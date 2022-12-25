package com.example.ak7mtprojekt.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ak7mtprojekt.localdata.DBWeatherInfo

@Dao
interface DBWeatherInfoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: DBWeatherInfo)

    @Delete
    suspend fun deleteCity(city: DBWeatherInfo)

    @Query("SELECT * FROM dbweatherinfo")
    fun getCities(): List<DBWeatherInfo>

}