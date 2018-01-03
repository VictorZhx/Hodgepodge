package com.victor.hodgepodge.home.mvp

/**
 * Created by victor on 17-9-26.
 */
object HomeEventType {
    // joke
    public val TYPE_JOKE_LIST_SUCCESS: Int = 1
    public val TYPE_JOKE_LIST_ERROR: Int = 2

    fun Thread.getTName(): String {

        return this.name
    }

}
