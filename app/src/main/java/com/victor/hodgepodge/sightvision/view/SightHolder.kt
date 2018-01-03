package com.victor.hodgepodge.sightvision.view

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.victor.hodgepodge.R
import com.victor.hodgepodge.base.BaseActivity
import com.victor.hodgepodge.base.BaseHolder
import com.victor.hodgepodge.sightvision.SightConstant
import com.victor.hodgepodge.sightvision.entity.NewsDetail
import com.victor.hodgepodge.utils.ImageUtils

/**
 * Created by victor on 17-9-28.
 */
class SightHolder(thisActivity: BaseActivity?, itemView: View?) : BaseHolder(thisActivity, itemView) {
    var titleTv: TextView? = itemView?.findViewById(R.id.sight_news_title) as TextView
    var authorTv: TextView? = itemView?.findViewById(R.id.sight_news_author) as TextView
    var timeTv: TextView? = itemView?.findViewById(R.id.sight_news_time) as TextView
    var icon1Tv: ImageView = itemView?.findViewById(R.id.sight_news_icon1) as ImageView
    var icon2Tv: ImageView = itemView?.findViewById(R.id.sight_news_icon2) as ImageView
    var icon3Tv: ImageView = itemView?.findViewById(R.id.sight_news_icon3) as ImageView

    override fun show(position: Int, item: Any?) {
        super.show(position, item)

        var newsDetail = item as NewsDetail


        authorTv?.text = newsDetail.author_name
        timeTv?.text = newsDetail.date

        var build = SpannableStringBuilder("")
        build.append(newsDetail.title)
        var span: ImageSpan? = null

        when (newsDetail.category) {

            SightConstant.CATEGORY_NEWS_TOP -> span = ImageSpan(thisActivity, R.drawable.ic_nature_black_18dp)
            SightConstant.CATEGORY_NEWS_GUONEI -> span = ImageSpan(thisActivity, R.drawable.ic_store_black_18dp)
            SightConstant.CATEGORY_NEWS_SHEHUI -> span = ImageSpan(thisActivity, R.drawable.ic_supervisor_account_black_18dp)
            SightConstant.CATEGORY_NEWS_GUOJI -> span = ImageSpan(thisActivity, R.drawable.ic_language_black_18dp)
            SightConstant.CATEGORY_NEWS_YULE -> span = ImageSpan(thisActivity, R.drawable.ic_music_note_black_18dp)
            SightConstant.CATEGORY_NEWS_TIYU -> span = ImageSpan(thisActivity, R.drawable.ic_rowing_black_18dp)
            SightConstant.CATEGORY_NEWS_JUNSHI -> span = ImageSpan(thisActivity, R.drawable.ic_center_focus_weak_black_18dp)
            SightConstant.CATEGORY_NEWS_KEJI -> span = ImageSpan(thisActivity, R.drawable.ic_touch_app_black_18dp)
            SightConstant.CATEGORY_NEWS_CAIJING -> span = ImageSpan(thisActivity, R.drawable.ic_add_shopping_cart_black_18dp)
            SightConstant.CATEGORY_NEWS_SHISHANG -> span = ImageSpan(thisActivity, R.drawable.ic_color_lens_black_18dp)

        }
        build.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        titleTv?.text = build

        ImageUtils.loadImage(newsDetail.thumbnail_pic_s, icon1Tv)
        ImageUtils.loadImage(newsDetail.thumbnail_pic_s02, icon2Tv)
        ImageUtils.loadImage(newsDetail.thumbnail_pic_s03, icon3Tv)


    }

}