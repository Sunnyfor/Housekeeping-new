package com.zhkj.housekeeping.base

/**
 * 接口配置清单
 * Created by zhangye on 2017/10/12.
 */
object Constant {

    fun isDebug(): Boolean = true

    var isLog = true //是否打印LOG

    fun getHost(): String = if (isDebug()) "http://www.zhenhekj.com:8807" else "http://api.tianapi.com"

    const val CLIENT = "android"

    const val TOTAL_PROJECT_URL = "dic/dicxiangmu/listByXiangMu" //全部项目

    const val LOGIN_URL = "sys/login?IsGay=true" //登录

    const val LISTBYUSERIDZHFZ_URL ="dic/dicxiangmu/listByUserIdZhFz"
}