package com.victor.hodgepodge.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseFragment
import com.victor.hodgepodge.base.MyApplication

/**
 * Created by victor on 17-9-30.
 */
object ImageUtils {


    public fun loadImage(url: String, imageView: ImageView) {

        Glide.with(MyApplication.getInstance())
                .load(url)
                .into(imageView)

    }

    public fun loadImage(activity: BaseActivity, url: String, imageView: ImageView) {

        Glide.with(activity)
                .load(url)
                .into(imageView)

    }

    public fun loadImage(fragment: BaseFragment, url: String, imageView: ImageView) {

        Glide.with(fragment)
                .load(url)
                .into(imageView)

    }

}