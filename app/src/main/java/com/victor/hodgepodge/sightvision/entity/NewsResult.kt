package com.victor.hodgepodge.sightvision.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victor on 17-9-28.
 */
data class NewsResult constructor(var error_code: Int = 0) : Parcelable {
    public var reason: String = ""

    public var result: NewsDatas? = null

    constructor(source: Parcel) : this(
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(error_code)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NewsResult> = object : Parcelable.Creator<NewsResult> {
            override fun createFromParcel(source: Parcel): NewsResult = NewsResult(source)
            override fun newArray(size: Int): Array<NewsResult?> = arrayOfNulls(size)
        }
    }
}