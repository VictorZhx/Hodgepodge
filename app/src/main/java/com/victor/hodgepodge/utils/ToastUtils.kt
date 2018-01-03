package com.victor.hodgepodge.utils

import android.widget.Toast
import com.victor.hodgepodge.base.MyApplication

/**
 * Created by victor on 17-10-2.
 */
object ToastUtils {

    fun showShort(msg: String?) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show()
    }

    fun showLong(msg: String?) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_LONG).show()
    }
}