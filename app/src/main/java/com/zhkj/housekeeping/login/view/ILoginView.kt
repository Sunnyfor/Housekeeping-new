package com.zhkj.housekeeping.login.view

import com.zhkj.housekeeping.base.BaseModel
import com.zhkj.housekeeping.base.IBaseView

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 18:14
 */
interface ILoginView:IBaseView {
    
    //登录结果回调
    fun loginResult(baseModel: BaseModel<String>)


    fun passWordState(isShow:Boolean){

    }
}