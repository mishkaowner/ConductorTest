package com.mishkaowner.conductortest

import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class MainInteractorImpl @Inject constructor(private val service : TestService) : MainInteractor {
    private var users: List<User>? = null

    private val webRepo: WebRepository by lazy {
        WebRepository(service)
    }

    private val localRepo: LocalRepository by lazy {
        LocalRepository()
    }

    override fun getUsers(): Observable<List<User>> {
        return Maybe.concat(getCurrentUsers(),
                getUsersFromLocal(),
                getUsersFromWeb())
                .firstElement()
                .toObservable()
    }

    private fun getUsersFromWeb(): Maybe<List<User>> {
        return webRepo.getUsers().doOnNext { localRepo.updateUsers(it) }.doOnNext { users = it }.firstElement()
    }

    private fun getUsersFromLocal(): Maybe<List<User>> {
        return localRepo.getUsers().filter { it.isNotEmpty() }.doOnNext { users = it }.firstElement()
    }

    private fun getCurrentUsers(): Maybe<List<User>> {
        return Maybe.fromCallable { users }
    }
}