package com.mishkaowner.conductortest

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class MainPresenterImpl @Inject constructor(private val view: MainView) : MainPresenter {
    @Inject lateinit var mainInteractor: MainInteractor

    override fun onCreate() {
        mainInteractor.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.updateList(it)
                }, { it.printStackTrace() })
    }

    override fun onResume() {
    }
}