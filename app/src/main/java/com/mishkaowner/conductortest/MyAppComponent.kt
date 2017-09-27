package com.mishkaowner.conductortest

import dagger.Component
import javax.inject.Singleton

/**
 * Created by MishkaOwner on 2017-09-28.
 */
@Singleton
@Component(modules = arrayOf(MyAppModule::class, ServiceModule::class))
interface MyAppComponent {
    fun plus(module: MainModule) : MainComponent
}