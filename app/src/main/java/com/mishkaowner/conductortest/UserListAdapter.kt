package com.mishkaowner.conductortest

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.reactivex.Observable

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class UserListAdapter(private val currentUsers : MutableList<User>, private val context : Context?) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        holder?.onBind(currentUsers[position])
    }

    override fun getItemCount(): Int {
        return currentUsers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    fun updateList(newUsers: List<User>) {
        Observable.fromCallable{
            DiffUtil.calculateDiff(DiffCB(currentUsers, newUsers))
        }.subscribe{result ->
            currentUsers.clear()
            currentUsers.addAll(newUsers)
            result.dispatchUpdatesTo(this)
        }
    }
}