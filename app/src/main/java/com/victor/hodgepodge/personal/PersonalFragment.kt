package com.victor.hodgepodge.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseFragment

/**
 * Created by victor on 17-9-23.
 */
class PersonalFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(activity).inflate(R.layout.personal_main_layout, null)

        return rootView
    }

    companion object FragmentInstance {
        private val personalFragment: PersonalFragment = PersonalFragment()
        fun getInstance(): BaseFragment {
            return personalFragment
        }
    }
}