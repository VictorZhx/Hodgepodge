package com.victor.hodgepodge.base

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by victor on 17-9-26.
 */
open class BasePresenter constructor(baseView: IBaseView) {


    public fun registerEvent() {

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    public fun unRegisterEvent() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    @Subscribe
    public open fun onEvent(baseEvent: BaseEvent) {

    }


}