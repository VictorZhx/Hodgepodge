package com.victor.hodgepodge.home.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victor on 17-9-26.
 */
data class JokeResult constructor(var error_code: Int = -1) : Parcelable {
    public var reason: String = ""

    public var result: JokeDatas? = null

    constructor(source: Parcel) : this(
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(error_code)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<JokeResult> = object : Parcelable.Creator<JokeResult> {
            override fun createFromParcel(source: Parcel): JokeResult = JokeResult(source)
            override fun newArray(size: Int): Array<JokeResult?> = arrayOfNulls(size)
        }
    }
}