package com.alessandrofarandagancio.geckowrapper.di

import com.alessandrofarandagancio.geckowrapper.api.gecko.ApiHelper
import com.alessandrofarandagancio.geckowrapper.api.gecko.ApiHelperImpl
import com.alessandrofarandagancio.geckowrapper.api.gecko.ApiService
import com.alessandrofarandagancio.geckowrapper.constant.baseGeckoRestApiUrl
import com.google.maps.android.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("base_gecko")
    fun provideGeckoBaseUrl() = baseGeckoRestApiUrl


    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    @Named("retrofit_gecko")
    fun provideYelpRetrofit(
        okHttpClient: OkHttpClient,
        @Named("base_gecko") yelpBaseUrl: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(yelpBaseUrl)
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    fun provideApiService(@Named("retrofit_gecko") retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper



}