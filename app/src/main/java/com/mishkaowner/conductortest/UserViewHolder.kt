package com.mishkaowner.conductortest

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by MishkaOwner on 2017-09-28.
 */
class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun onBind(user : User) {
        GlideApp.with(itemView.context).load(user.avatarUrl).override(75, 75).diskCacheStrategy(DiskCacheStrategy.ALL).into(itemView.imgView)
        itemView.name.text = user.name
    }
}