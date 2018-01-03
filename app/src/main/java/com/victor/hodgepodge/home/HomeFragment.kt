package com.victor.hodgepodge.home

import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseFragment
import com.victor.hodgepodge.home.entity.JokeResult
import com.victor.hodgepodge.home.mvp.IHomeView
import com.victor.hodgepodge.home.mvp.JokePresenter
import com.victor.hodgepodge.home.view.HomeAdapter
import java.util.*

/**
 * Created by victor on 17-9-23.
 */
class HomeFragment : BaseFragment(), IHomeView {

    private var recycleView: RecyclerView? = null
    private var refreshLayout: SwipeRefreshLayout? = null
    private var homeAdapter: HomeAdapter? = null
    private var layoutMananger: LinearLayoutManager? = null
    private var presenter = JokePresenter(this)


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart --> : ")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, "onAttach --> : ")
        presenter.registerEvent()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.unRegisterEvent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate --> : ")

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(activity).inflate(R.layout.home_main, null)
        recycleView = rootView?.findViewById(R.id.home_swipe_list) as RecyclerView
        refreshLayout = rootView?.findViewById(R.id.home_swipe_fresh) as SwipeRefreshLayout

        layoutMananger = LinearLayoutManager(activity)
        recycleView?.layoutManager = layoutMananger
        homeAdapter = HomeAdapter(activity as BaseActivity?)
        recycleView?.adapter = homeAdapter

        refreshLayout?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { presenter.getJokeCollections() })

        Log.i(TAG, "onCreateView -->  currentTimeMillis : " + Calendar.getInstance().time.toString())
        Log.i(TAG, "onCreateView -->  currentTimeMillis : " + Calendar.getInstance().timeInMillis.toString())
        presenter.getJokeCollections()

        return rootView
    }


    companion object FragmentInstance {
        private val homeFragment: HomeFragment = HomeFragment()
        fun getInstance(): BaseFragment {
            return homeFragment
        }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showList(jokeResult: JokeResult?) {

        refreshLayout?.isRefreshing = false
        if (null == jokeResult?.result?.data) {

            return
        }

        homeAdapter?.refreshData(jokeResult.result?.data)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}