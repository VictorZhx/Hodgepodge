package com.victor.hodgepodge.home.mvp

import com.victor.hodgepodge.base.IBaseView
import com.victor.hodgepodge.home.entity.JokeResult

/**
 * Created by victor on 17-9-26.
 */
interface IHomeView : IBaseView {

    fun showList(jokeResult: JokeResult?)

    fun showError()
}