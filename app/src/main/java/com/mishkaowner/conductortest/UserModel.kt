package com.mishkaowner.conductortest

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by MishkaOwner on 2017-09-28.
 */
open class UserModel(@PrimaryKey open var id: Long = 0,
                     var name: String? = null,
                     var img: String? = null) : RealmObject()