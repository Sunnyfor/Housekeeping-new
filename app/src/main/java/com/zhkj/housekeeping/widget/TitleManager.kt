package com.zhkj.housekeeping.widget

import android.view.View
import com.zhkj.housekeeping.R
import com.zhkj.housekeeping.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.layout_default_title.view.*

/**
 * Desc 标题管理类
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 0022 12:12
 */
class TitleManager(private var baseActivity: BaseActivity) {

    fun defaultTitle(title: String): View {
        val view = View.inflate(baseActivity, R.layout.layout_default_title, null)
        view.tvTitle.text = title
        view.tvLeft.setOnClickListener(getBackClickListener())
        return view
    }

    fun goneTitle() {
        baseActivity.fl_title.visibility = View.GONE
        baseActivity.view_line.visibility = View.GONE
    }

    private fun getBackClickListener(): View.OnClickListener = View.OnClickListener {
        baseActivity.finish()
    }

}