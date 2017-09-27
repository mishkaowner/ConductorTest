package com.mishkaowner.conductortest

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by MishkaOwner on 2017-09-28.
 */
@Module
class ServiceModule {
    @Provides fun providesTestService(): TestService = Retrofit.Builder()
            .baseUrl(TestService.END_POINT)
            .client(OkHttpClient.Builder().build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .build()
            .create(TestService::class.java)
}