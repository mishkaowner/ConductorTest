package com.mishkaowner.conductortest

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class MyApp : Application() {
    companion object {
        @JvmStatic
        lateinit var component : MyAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        component = DaggerMyAppComponent.builder().myAppModule(MyAppModule(this)).build()
    }
}