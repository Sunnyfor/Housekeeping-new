package com.zhkj.housekeeping.login

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.zhkj.housekeeping.R
import com.zhkj.housekeeping.base.BaseActivity
import com.zhkj.housekeeping.base.BaseModel
import com.zhkj.housekeeping.constant.SpConstant
import com.zhkj.housekeeping.login.presenter.LoginPresenter
import com.zhkj.housekeeping.login.view.ILoginView
import com.zhkj.housekeeping.util.SpUtil
import com.zhkj.housekeeping.work.TotalProjectActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

/**
 * Desc 登录
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/21 22:41
 */
class LoginActivity : BaseActivity(), ILoginView {


    private val loginPresenter: LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun setLayout(): Int = R.layout.activity_login

    override fun initView() {
        titleManager.goneTitle()
        btn_login.setOnClickListener(this)


        //是否记住登录
        val isRemember = SpUtil.getBoolean(SpConstant.isRememberPassword, false)
        if (isRemember) { //将账号和密码都设置到文本中
            val username = SpUtil.getString(SpConstant.username)
            val password = SpUtil.getString(SpConstant.password)
            et_username.setText(username)
            et_password.setText(password)
            cb_remember_pwd.isChecked = true
            btn_login.performClick()
        }

        //设置密码显示与隐藏
        cb_show_password.setOnCheckedChangeListener { _, isChecked ->
            et_password.transformationMethod = if (isChecked) {
                HideReturnsTransformationMethod.getInstance()
            } else {
                PasswordTransformationMethod.getInstance()
            }
            et_password.setSelection(et_password.text.toString().length)
        }


        checkPermission()
    }

    override fun update() {
    }

    override fun loadData() {

    }

    override fun close() {

    }

    override fun onClick(v: View) {
        when (v.id) {
            btn_login.id -> {
                val username = et_username.text.toString()
                val password = et_password.text.toString()

                if (username.isEmpty()) {
                    Toast.makeText(this@LoginActivity, "请输入账号", Toast.LENGTH_SHORT).show()
                    return
                }

                if (password.isEmpty()) {
                    Toast.makeText(this@LoginActivity, "请输入密码", Toast.LENGTH_SHORT).show()
                    return
                }

                loginPresenter.login(username, password)
            }
        }
    }


    override fun loginResult(baseModel: BaseModel<String>) {
        startActivity(Intent(this, TotalProjectActivity::class.java))
    }


    private var times = 0
    private val REQUEST_PHONE_PERMISSIONS = 0
    private fun checkPermission() {
        times++
        val permissionsList = ArrayList<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.ACCESS_NETWORK_STATE
                )
            }
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.READ_PHONE_STATE
                )
            }
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            }
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            }
            if (checkSelfPermission(Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.CAMERA
                )
            }
            if (checkSelfPermission(Manifest.permission.BLUETOOTH) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.BLUETOOTH
                )
            }
            if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) !== PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(
                    Manifest.permission.RECORD_AUDIO
                )
            }
            if (permissionsList.size != 0) {
                if (times == 1) {
                    requestPermissions(
                        permissionsList.toTypedArray(),
                        REQUEST_PHONE_PERMISSIONS
                    )
                } else {
                    AlertDialog.Builder(this)
                        .setCancelable(true)
                        .setTitle("提示")
                        .setMessage("获取不到授权，APP将无法正常使用，请允许APP获取权限！")
                        .setPositiveButton("确定") { arg0, arg1 ->
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(
                                    permissionsList.toTypedArray(),
                                    REQUEST_PHONE_PERMISSIONS
                                )
                            }
                        }.setNegativeButton(
                            "取消"
                        ) { _, _ -> finish() }.show()
                }
            } else {
                startService()
            }
        } else {
            startService()
        }
    }

    private fun startService() {
//        val intent = Intent(this@LoginActivity, KeepLiveService::class.java)
//        startService(intent)
    }
}