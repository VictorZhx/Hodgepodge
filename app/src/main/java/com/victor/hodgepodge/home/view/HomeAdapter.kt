package com.victor.hodgepodge.home.view

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseAdapter
import com.victor.hodgepodge.base.BaseHolder
import com.victor.hodgepodge.home.entity.JokeDetail
import com.victor.hodgepodge.utils.InflateUtils

/**
 * Created by victor on 17-9-27.
 */
class HomeAdapter(thisActivity: BaseActivity?) : BaseAdapter<JokeDetail, HomeAdapter.HomeHolder>(thisActivity) {
    private val TAG: String = "HomeAdapter"

    var jokeDetails: MutableList<JokeDetail> = mutableListOf()


    // 刷新数据
    override public fun refreshData(newDatas: MutableList<JokeDetail>?) {

        if (!jokeDetails.isEmpty()) {
            jokeDetails.clear()
        }

        if (newDatas != null) {
            jokeDetails.addAll(newDatas)
        }
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: HomeHolder?, position: Int) {

        if (position < 0 || position > itemCount || holder == null) {
            return
        }

        holder.show(position, getItem(position))
    }

    override fun getItem(position: Int): JokeDetail {
        Log.d(TAG, "getItem --> : ")
        return jokeDetails.get(position)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount --> : ")
        return jokeDetails.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {

        var homeHolder = HomeHolder(thisActivity, InflateUtils.inflateView(R.layout.home_joke_item_layout, null))

        return homeHolder
    }


    inner class HomeHolder(thisActivity: BaseActivity?, itemView: View?) : BaseHolder(thisActivity, itemView) {
        var contentTv: TextView = itemView?.findViewById(R.id.home_joke_content) as TextView
        var timeTv: TextView = itemView?.findViewById(R.id.home_joke_time) as TextView


        override fun show(position: Int, item: Any?) {
            super.show(position, item)

//            var itemDetail: JokeDetail? = null
//            if (item is JokeDetail) {
//                itemDetail = item
//            }

            val itemDetail: JokeDetail? = item as?JokeDetail

            contentTv.text = itemDetail?.content
            timeTv.text = itemDetail?.updatetime


        }

    }

}