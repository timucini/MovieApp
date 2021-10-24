package com.example.testmovieapp.di

import com.example.testmovieapp.data.firebase.FirebaseSource
import com.example.testmovieapp.repositories.AuthenticationRepository
import com.example.testmovieapp.ui.viewmodels.AuthenticationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideFirebaseSource(): FirebaseSource = FirebaseSource()

    @Singleton
    @Provides
    fun provideAuthRepository(firebaseSource: FirebaseSource):
            AuthenticationRepository = AuthenticationRepository(firebaseSource)

    @Singleton
    @Provides
    fun provideViewModel(authenticationRepository: AuthenticationRepository):
            AuthenticationViewModel = AuthenticationViewModel(authenticationRepository)
}