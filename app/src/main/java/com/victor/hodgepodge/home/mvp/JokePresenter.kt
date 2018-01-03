package com.victor.hodgepodge.home.mvp

import android.util.Log
import com.victor.hodgepodge.base.BaseEvent
import com.victor.hodgepodge.base.BasePresenter
import com.victor.hodgepodge.constants.AppConstants
import com.victor.hodgepodge.home.entity.JokeResult

/**
 * Created by victor on 17-9-25.
 */
class JokePresenter constructor(var homeView: IHomeView) : BasePresenter(homeView) {
    private val TAG = "JokePresenter"

    private val jokeInterceptor = JokeInterceptor()


    public fun getJokeCollections(key: String = AppConstants.REQUEST_KEY_JOKE, page: Int = 1, pagesize: Int = 20, sort: String = "asc", time: String = System.currentTimeMillis().toString().substring(2, 12)) {

        jokeInterceptor.getJokeCollections(key, page, pagesize, sort, time)

    }


    override fun onEvent(baseEvent: BaseEvent) {

        Log.d(TAG, "onEvent --> JokePresenter.type : " + baseEvent.type)
        when (baseEvent.type) {

            HomeEventType.TYPE_JOKE_LIST_SUCCESS -> {
                val bundle = baseEvent.bundle
                val jokeResult = bundle?.getParcelable<JokeResult>(HomeConstants.PARAM_KEY_RESULT)

                homeView.showList(jokeResult)
            }

            HomeEventType.TYPE_JOKE_LIST_ERROR -> homeView.showError()
        }

    }

}