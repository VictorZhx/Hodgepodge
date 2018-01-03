package com.victor.hodgepodge.sightvision.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victor on 17-9-28.
 */
data class NewsDetail constructor(var uniquekey: String = "") : Parcelable {
    var title: String = ""

    var date: String = ""

    var category: String = ""

    var author_name: String = ""

    var url: String = ""

    var thumbnail_pic_s: String = ""

    var thumbnail_pic_s02: String = ""

    var thumbnail_pic_s03: String = ""

    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(uniquekey)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<NewsDetail> = object : Parcelable.Creator<NewsDetail> {
            override fun createFromParcel(source: Parcel): NewsDetail = NewsDetail(source)
            override fun newArray(size: Int): Array<NewsDetail?> = arrayOfNulls(size)
        }
    }
}