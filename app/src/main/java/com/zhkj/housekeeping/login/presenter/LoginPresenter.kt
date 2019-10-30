package com.zhkj.housekeeping.login.presenter

import com.zhkj.housekeeping.base.BaseModel
import com.zhkj.housekeeping.base.BasePresenter
import com.zhkj.housekeeping.base.Constant
import com.zhkj.housekeeping.http.ApiManager
import com.zhkj.housekeeping.login.view.ILoginView
import org.json.JSONObject

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 18:20
 */
class LoginPresenter(view: ILoginView) : BasePresenter<ILoginView>(view) {

    var isSavePass = false
    var isShowPass = false

    override fun onCreate() {
        //查询操作
    }

    override fun onClose() {

    }


    fun login(username: String, password: String) {
        val params = JSONObject()
        params.put("username", username)
        params.put("password", password)
        ApiManager.postJson(
            composites,
            params.toString(),
            Constant.LOGIN_URL,
            object : ApiManager.OnResult<BaseModel<String>>() {
                override fun onSuccess(data: BaseModel<String>) {
                    if (data.msg == "success"){

                        if (isSavePass){
                            //保存密码
                        }else{
                            //清空密码
                        }

                        view?.loginResult(data)
                    }

                }

                override fun onFailed(code: String, message: String) {

                }

            })
    }

    fun savePassWord(isSavePass:Boolean){
        this.isSavePass = isSavePass
        //保存操作

    }

    fun isShowPassword(isShowPass: Boolean){
        this.isShowPass = isShowPass
        //保存操作
    }
}