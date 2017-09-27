package com.mishkaowner.conductortest

import io.reactivex.Observable

/**
 * Created by MishkaOwner on 2017-09-28.
 */
interface BaseRepository {
    fun getUsers() : Observable<List<User>>

    fun updateUsers(users : List<User>)
}