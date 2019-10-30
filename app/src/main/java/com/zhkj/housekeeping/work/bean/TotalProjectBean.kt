package com.zhkj.housekeeping.project.bean

/**
 * Desc 项目实体类
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 0022 12:02
 */
class TotalProjectBean {

    var code: Int = 0
    var msg: String? = null

    var data: Map<String, ArrayList<Data>>? = null


    class Data {

        var renYuanId: Int? = 0
        var renYuanName: String? = null
        var xiangMuId: Int? = 0
        var xiangMuName: String? = null
        var buMenMc: String? = null

        var dicXiangmuEntity: DicXiangmuEntity? = null

        var dataType: Int? = 0

        class DicXiangmuEntity {
            var xiangMuId: Int? = 0
            var xiangMuMingcheng: String? = null
            var xiangMuBianhao: String? = null
            var state: Int? = 0
            var chuangJianR: Int? = 0
            var chuangJianRq: String? = null
            var xiuGaiR: String? = null
            var xiuGaiRq: String? = null
            var chuangJianRName: String? = null
            var xiangMuFzr: Int? = 0
            var youXianJi: Int? = 0

            override fun toString(): String {
                return "DicXiangmuEntity(xiangMuId=$xiangMuId, xiangMuMingcheng=$xiangMuMingcheng, xiangMuBianhao=$xiangMuBianhao, state=$state, chuangJianR=$chuangJianR, chuangJianRq=$chuangJianRq, xiuGaiR=$xiuGaiR, xiuGaiRq=$xiuGaiRq, chuangJianRName=$chuangJianRName, xiangMuFzr=$xiangMuFzr, youXianJi=$youXianJi)"
            }

        }

        override fun toString(): String {
            return "Data(renYuanId=$renYuanId, renYuanName=$renYuanName, xiangMuId=$xiangMuId, xiangMuName=$xiangMuName, buMenMc=$buMenMc, dicXiangmuEntity=$dicXiangmuEntity, dataType=$dataType)"
        }


    }

    override fun toString(): String {
        return "TotalProjectBean(code=$code, msg=$msg, data=$data)"
    }


}