package com.example.ak7mtprojekt.di

import android.app.Application
import androidx.room.Room
import com.example.ak7mtprojekt.data.DBWeatherInfoDatabase
import com.example.ak7mtprojekt.data.WeatherRepository
import com.example.ak7mtprojekt.data.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDBWeatherInfoDatabase(app: Application) : DBWeatherInfoDatabase {
        return Room.databaseBuilder(
            app,
            DBWeatherInfoDatabase::class.java,
            "dbweatherinfo"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(db: DBWeatherInfoDatabase) : WeatherRepository {
        return WeatherRepositoryImpl(db)
    }
}