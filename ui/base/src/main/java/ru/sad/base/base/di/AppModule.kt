package ru.sad.base.base.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        private const val SHARED_PREFERENCES_NAME = "Lifestory"
        private const val APP_NAME = "Questionary"
        private const val APP_VERSION = "1.0.1"

        private val userAgent: String by lazy {
            APP_NAME + "/" + APP_VERSION + " " + System.getProperty("http.agent")
        }
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideResources(application: Application): Resources {
        return application.resources
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}