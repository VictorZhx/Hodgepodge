package com.victor.hodgepodge.sightvision.mvp

import com.victor.hodgepodge.base.BasePresenter
import com.victor.hodgepodge.constants.AppConstants
import com.victor.hodgepodge.home.mvp.HomeConstants
import com.victor.hodgepodge.sightvision.SightConstant
import com.victor.hodgepodge.sightvision.entity.NewsResult
import com.victor.hodgepodge.utils.LOG
import org.greenrobot.eventbus.Subscribe

/**
 * Created by victor on 17-9-28.
 */
class NewsPresenter constructor(var newsView: INewsView) : BasePresenter(newsView) {
    private val TAG = "NewsPresenter"
    private var newsInterceptor: NewsInterceptor = NewsInterceptor()

    fun queryNewsList(key: String = AppConstants.REQUEST_KEY_NEWS, type: String = "top") {

        newsInterceptor.queryNews(key, type)

    }

    @Subscribe
    fun onEvent(sightEvent: SightEvent) {

        if (LOG.D) {
            LOG.d(TAG, " onEvent --> SightEvent: ")
        }

        when (sightEvent.type) {

            SightConstant.TYPE_NEWS_LIST_SUCCESS -> {

                val bundle = sightEvent.bundle
                val newsResult = bundle?.getParcelable<NewsResult>(HomeConstants.PARAM_KEY_RESULT)

                newsView.showNewsList(newsResult)

            }
            SightConstant.TYPE_NEWS_LIST_ERROR -> newsView.showNewsError()
        }

    }
}