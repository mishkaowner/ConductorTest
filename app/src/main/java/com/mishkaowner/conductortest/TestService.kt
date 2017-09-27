package com.mishkaowner.conductortest

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by MishkaOwner on 2017-09-28.
 */
interface TestService {
    companion object {
        val END_POINT : String = "https://api.github.com"
    }

    @GET("/users")
    fun getUsers(): Observable<List<UserResponse>>
}