package com.victor.hodgepodge.base

import org.greenrobot.eventbus.EventBus

/**
 * Created by victor on 17-9-28.
 */
open class BaseInterceptor {

    protected val eventBus = EventBus.getDefault()

    protected fun post(baseEvent: BaseEvent) {
        eventBus.post(baseEvent)
    }

}