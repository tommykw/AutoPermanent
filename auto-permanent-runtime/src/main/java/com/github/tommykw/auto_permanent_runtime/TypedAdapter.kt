package com.github.tommykw.auto_permanent_runtime

import android.os.Parcel

@Beta
interface TypedAdapter<T> {
    fun toParcel(value: T, parcel: Parcel, flags: Int)
    fun fromParcel(parcel: Parcel): T
}