package com.example.ak7mtprojekt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ak7mtprojekt.localdata.DBWeatherInfo

@Database(entities = [DBWeatherInfo::class], version = 1)
abstract class DBWeatherInfoDatabase : RoomDatabase() {

    abstract val cityWeatherDao : DBWeatherInfoDAO

}

private lateinit var INSTANCE: DBWeatherInfoDatabase

fun getDatabase(context: Context): DBWeatherInfoDatabase {
    synchronized(DBWeatherInfoDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                DBWeatherInfoDatabase::class.java,
                "dbweatherinfo").build()
        }
    }
    return INSTANCE
}