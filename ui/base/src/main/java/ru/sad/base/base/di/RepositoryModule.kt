package ru.sad.base.base.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sad.data.sharedprefs.PrefsRepository
import ru.sad.data.sharedprefs.PrefsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSharedPrefsRepository(): PrefsRepository = PrefsRepositoryImpl()
}