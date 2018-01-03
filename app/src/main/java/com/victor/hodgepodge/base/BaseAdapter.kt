package com.victor.hodgepodge.base

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter

/**
 * Created by victor on 17-9-29.
 */
abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder> constructor(var thisActivity: BaseActivity?) : Adapter<VH>() {

    abstract fun refreshData(newDatas: MutableList<T>?)
    abstract fun getItem(position: Int): T?
}