package com.zhkj.housekeeping.work.view

import com.zhkj.housekeeping.base.IBaseView
import com.zhkj.housekeeping.project.bean.TotalProjectBean

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 17:39
 */
interface IProjectView:IBaseView {

    //获取全部项目
    fun getTotalProjectData(totalProjectBean: TotalProjectBean)

}