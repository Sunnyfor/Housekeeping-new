package com.zhkj.housekeeping.base

/**
 * 公共实体类
 * Created by 张野 on 2017/9/14.
 */

class BaseModel<T> {
    var msg = ""
    var code = "0"
    var data: T? = null
    var type = javaClass

    override fun toString(): String =
        "BaseModel(code='$code', msg=$msg, data=$data, value=$type)"
}