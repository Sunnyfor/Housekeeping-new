package com.zhkj.housekeeping.constant

/**
 * Desc 接口配置清单
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/30 0030 18:13
 */
object UrlConstant {

    fun getHost(): String = if (true) "http://www.zhenhekj.com:8807" else "http://api.tianapi.com"

    const val CLIENT = "android"

    /**
     * 登录
     */
    const val LOGIN_URL = "sys/login?IsGay=true"

    /**
     * 全部项目
     */
    const val TOTAL_PROJECT_URL = "dic/dicxiangmu/listByXiangMu"

    /**
     * 我的项目
     */
    const val MY_PROJECT_URL = "dic/dicxiangmu/listByUserIdZhFz"
}