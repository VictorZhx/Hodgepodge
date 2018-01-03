package com.victor.hodgepodge.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.hodgepodge.base.MyApplication

/**
 * Created by victor on 17-9-27.
 */
class InflateUtils {


    companion object {

        fun inflateView(resId: Int, root: ViewGroup?): View {

            return getInflate(MyApplication.getInstance()).inflate(resId, root)

        }

        fun getInflate(contex: Context): LayoutInflater {
            return contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
    }
}