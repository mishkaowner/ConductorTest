package com.mishkaowner.conductortest

import io.reactivex.Observable

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class WebRepository  (val service: TestService) : BaseRepository {
    override fun getUsers(): Observable<List<User>> {
        return service.getUsers().map {
            it.map {
                val user = User(it.id, it.login, it.avatar_url)
                user
            }
        }
    }

    override fun updateUsers(users: List<User>) {
    }
}