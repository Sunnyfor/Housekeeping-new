package com.zhkj.housekeeping.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.zhkj.housekeeping.R
import com.zhkj.housekeeping.util.ToastUtil
import com.zhkj.housekeeping.widget.TitleManager
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.layout_error.view.*

/**
 *
 * Created by 张野 on 2018/8/2.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView, View.OnClickListener {

    val loadingView: View by lazy {
        View.inflate(this, R.layout.layout_loading, null)
    }

    val errorView: View by lazy {
        View.inflate(this, R.layout.layout_error, null)
    }

    lateinit var titleManager: TitleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //强制屏幕
        titleManager = TitleManager(this)
        setContentView(R.layout.activity_base)
        val bodyView = LayoutInflater.from(this).inflate(setLayout(), null, false)
        fl_body.addView(bodyView)

        loadingView.setOnClickListener { }
        errorView.setOnClickListener { }
        errorView.btnNext.setOnClickListener {
            hideError()
            loadData()
            update()
        }

        initView()
        loadData()
    }

    abstract fun setLayout(): Int

    abstract fun initView()

    abstract fun update()


    abstract fun loadData()

    abstract fun close()


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (event.action == MotionEvent.ACTION_DOWN) {
            if (this.currentFocus != null) {
                if (this.currentFocus?.windowToken != null) {
                    imm.hideSoftInputFromWindow(
                        this.currentFocus?.windowToken,
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }
            }
        }
        return super.onTouchEvent(event)
    }


    /**
     * 隐藏输入法键盘
     */
    fun hideKeyboard() {
        val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        im.hideSoftInputFromWindow(
            this.currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    override fun showLoading() {
        hideLoading()
        loadingView.setOnClickListener { }

        fl_body.addView(loadingView)
    }

    override fun hideLoading() {
        fl_body.removeView(loadingView)
    }

    override fun showError(errorType: ErrorViewType) {
        hideError()
        fl_body.addView(errorView)
        errorView.setOnClickListener { }
        errorView.tvDesc.text = errorType.errorMessage
    }

    override fun hideError() {
        fl_body.removeView(errorView)
    }

    override fun showMessage(message: String) {
        ToastUtil.show(message)
    }

    override fun onResume() {
        super.onResume()
        update()
    }


    override fun onDestroy() {
        super.onDestroy()
        close()
    }
}