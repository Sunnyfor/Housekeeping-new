package com.zhkj.housekeeping.work

import android.view.View
import com.zhkj.housekeeping.R
import com.zhkj.housekeeping.base.BaseActivity
import com.zhkj.housekeeping.project.bean.TotalProjectBean
import com.zhkj.housekeeping.work.presenter.ProjectPresenter
import com.zhkj.housekeeping.work.view.IProjectView

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 17:49
 */
class TotalProjectActivity : BaseActivity(), IProjectView {

    private val projectPresenter: ProjectPresenter by lazy {
        ProjectPresenter(this)
    }

    override fun setLayout(): Int = R.layout.activity_project_list

    override fun initView() {
        //加载所有项目
        projectPresenter.getTotalProjectData()
    }

    override fun update() {
    }

    override fun loadData() {
    }

    override fun close() {
    }

    override fun onClick(v: View?) {
    }

    //数据结果处理
    override fun getTotalProjectData(totalProjectBean: TotalProjectBean) {

    }
}