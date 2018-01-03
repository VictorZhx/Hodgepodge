package com.victor.hodgepodge.sightvision.mvp

import com.victor.hodgepodge.base.IBaseView
import com.victor.hodgepodge.sightvision.entity.NewsResult

/**
 * Created by victor on 17-9-28.
 */
interface INewsView : IBaseView {

    fun showNewsList(newsResult: NewsResult?)
    fun showNewsError()
}