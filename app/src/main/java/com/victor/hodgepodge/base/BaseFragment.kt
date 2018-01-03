package com.victor.hodgepodge.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by victor on 17-9-23.
 */
open class BaseFragment : Fragment() {

    protected val TAG = "BaseFragment"
    protected var rootView: View? = null
//    protected var presenter: BasePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}