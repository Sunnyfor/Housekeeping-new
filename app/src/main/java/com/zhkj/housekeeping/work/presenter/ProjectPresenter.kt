package com.zhkj.housekeeping.work.presenter

import com.zhkj.housekeeping.base.BasePresenter
import com.zhkj.housekeeping.base.Constant
import com.zhkj.housekeeping.http.ApiManager
import com.zhkj.housekeeping.project.bean.TotalProjectBean
import com.zhkj.housekeeping.work.view.IProjectView

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 17:38
 */
class ProjectPresenter(view: IProjectView): BasePresenter<IProjectView>(view){
    override fun onCreate() {

    }

    override fun onClose() {

    }

    /**
     * 全部项目
     */
    fun getTotalProjectData(){
        val map = HashMap<String,String>()
//        map["deptId"] = "1"
//        map["deptName"] = "2"
        ApiManager.post(composites,map,Constant.LISTBYUSERIDZHFZ_URL,object :ApiManager.OnResult<TotalProjectBean>(){
            override fun onSuccess(data: TotalProjectBean) {
//                view?.getTotalProjectData(data)
            }

            override fun onFailed(code: String, message: String) {

            }

        })
    }

}