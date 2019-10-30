package com.zhkj.housekeeping.util

import android.widget.Toast
import com.zhkj.housekeeping.base.MyApplication

/**
 * Desc 单例Toast
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 17:38
 */
object ToastUtil {

    private var toast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT)
    private var layoutToast: Toast = Toast(MyApplication.getInstance())

    /**
     * 显示Toast
     * @param content Toast信息
     */
    fun show(content: String?, type: Int) {
        content?.let {
            toast.setText(content)
            toast.duration = type
            toast.show()
        }
    }

    fun show(content: String?) {
        show(content, Toast.LENGTH_SHORT)
    }

}