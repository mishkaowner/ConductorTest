package com.mishkaowner.conductortest

import io.reactivex.Observable

/**
 * Created by MishkaOwner on 2017-09-28.
 */
interface MainInteractor {
    fun getUsers() : Observable<List<User>>
}