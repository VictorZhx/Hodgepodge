package com.victor.hodgepodge.sightvision

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseFragment
import com.victor.hodgepodge.sightvision.entity.NewsResult
import com.victor.hodgepodge.sightvision.mvp.INewsView
import com.victor.hodgepodge.sightvision.mvp.NewsPresenter
import com.victor.hodgepodge.sightvision.view.SightAdapter
import com.victor.hodgepodge.utils.ToastUtils

/**
 * Created by victor on 17-9-23.
 */
class SightVisionFragment : BaseFragment(), INewsView {

    private var sightPresenter = NewsPresenter(this)
    private var refreshLayout: SwipeRefreshLayout? = null
    private var recycleView: RecyclerView? = null
    private var linearlayoutManager: LinearLayoutManager? = null
    private var sightAdapter: SightAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(activity).inflate(R.layout.sight_vision_layout, null)

        refreshLayout = rootView?.findViewById(R.id.sight_swipe_fresh) as SwipeRefreshLayout
        recycleView = rootView?.findViewById(R.id.sight_swipe_list) as RecyclerView

        linearlayoutManager = LinearLayoutManager(activity)
        recycleView?.layoutManager = linearlayoutManager

        sightAdapter = SightAdapter(activity as BaseActivity)
        recycleView?.adapter = sightAdapter
        sightPresenter.queryNewsList()

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, "onAttach --> : ")
        sightPresenter.registerEvent()
    }

    override fun onDetach() {
        super.onDetach()
        sightPresenter.unRegisterEvent()
    }

    companion object FragmentInstance {
        private val sightFragment: SightVisionFragment = SightVisionFragment()
        fun getInstance(): BaseFragment {
            return sightFragment
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showNewsList(newsResult: NewsResult?) {

        if (newsResult?.error_code == 0) {

            val data = newsResult.result?.data
            if (data != null) {
                sightAdapter?.refreshData(data)
            }
        } else {

            if (!TextUtils.isEmpty(newsResult?.reason)) {
                ToastUtils.showShort(newsResult?.reason)
            }
        }


    }

    override fun showNewsError() {
    }


}