package com.victor.hodgepodge.sightvision.view

import android.view.ViewGroup
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseAdapter
import com.victor.hodgepodge.sightvision.entity.NewsDetail
import com.victor.hodgepodge.utils.InflateUtils

/**
 * Created by victor on 17-9-28.
 */
class SightAdapter(thisActivity: BaseActivity) : BaseAdapter<NewsDetail, SightHolder>(thisActivity) {

    private var datas: MutableList<NewsDetail> = mutableListOf()

    override fun refreshData(newDatas: MutableList<NewsDetail>?) {

        if (datas.isNotEmpty()) datas.clear()

        if (newDatas != null) {
            datas.addAll(newDatas)
        }
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: SightHolder?, position: Int) {

        holder?.show(position, getItem(position))

    }

    override fun getItem(position: Int): NewsDetail {

        return datas.get(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SightHolder {

        val sightHolder = SightHolder(thisActivity, InflateUtils.inflateView(R.layout.news_item_layout, null))

        return sightHolder

    }
}