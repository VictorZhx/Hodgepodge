package com.victor.hodgepodge.utils

import android.util.Log
import com.victor.hodgepodge.BuildConfig

/**
 * Created by victor on 17-9-28.
 */
object LOG {
    public val D: Boolean = BuildConfig.DEBUG
    public val I: Boolean = BuildConfig.DEBUG
    public val E: Boolean = BuildConfig.DEBUG

    public fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }
}