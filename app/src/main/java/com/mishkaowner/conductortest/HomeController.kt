package com.mishkaowner.conductortest

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_home.view.*
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class HomeController : Controller, MainView {
    @Inject lateinit var presenter : MainPresenter

    lateinit var  adapter : UserListAdapter

    override fun updateList(users: List<User>) {
        adapter.updateList(users)
    }

    constructor() : super()

    constructor(args : Bundle?) : super(args)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_home, container, false)
        adapter = UserListAdapter(ArrayList(), view?.context)
        view?.recyclerView?.layoutManager = LinearLayoutManager(view?.context)
        view?.recyclerView?.adapter = adapter
        onViewBound()
        return view
    }

    private fun onViewBound(){
        MyApp.component.plus(MainModule(this)).inject(this)
        presenter.onCreate()
    }
}