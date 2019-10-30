package com.zhkj.housekeeping.login

import android.content.Intent
import android.view.View
import com.orhanobut.logger.Logger
import com.zhkj.housekeeping.R
import com.zhkj.housekeeping.base.BaseActivity
import com.zhkj.housekeeping.base.BaseModel
import com.zhkj.housekeeping.login.presenter.LoginPresenter
import com.zhkj.housekeeping.login.view.ILoginView
import com.zhkj.housekeeping.util.ToastUtil
import com.zhkj.housekeeping.util.dimensmak.DimensBuild
import com.zhkj.housekeeping.work.TotalProjectActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Desc 登录
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/21 22:41
 */
class LoginActivity: BaseActivity(),ILoginView {


    private val loginPresenter:LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun setLayout(): Int = R.layout.activity_login

    override fun initView() {
        btnLogin.setOnClickListener(this)
    }

    override fun update() {
    }

    override fun loadData() {

    }

    override fun close() {

    }

    override fun onClick(v: View) {
        when(v.id){
            btnLogin.id -> {
                loginPresenter.login("王哲","123456")
            }
        }
    }


    override fun loginResult(baseModel: BaseModel<String>) {
        startActivity(Intent(this, TotalProjectActivity::class.java))
    }
}