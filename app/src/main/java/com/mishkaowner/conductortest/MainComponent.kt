package com.mishkaowner.conductortest

import dagger.Subcomponent

/**
 * Created by MishkaOwner on 2017-09-28.
 */
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(controller: HomeController)
}