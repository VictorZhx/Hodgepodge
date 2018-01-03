package com.victor.hodgepodge.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by victor on 17-9-27.
 */
open class BaseHolder(var thisActivity: BaseActivity?, itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var pos: Int = 0

    open fun show(position: Int, item: Any?) {
        pos = position
    }
}