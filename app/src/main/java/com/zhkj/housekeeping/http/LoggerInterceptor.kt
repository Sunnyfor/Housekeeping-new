package com.zhkj.housekeeping.http

import android.text.TextUtils
import com.orhanobut.logger.Logger
import okhttp3.*
import okio.Buffer
import java.io.IOException

/**
 * Desc OKHttp日志拦截
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/22 0022 12:02
 */
class LoggerInterceptor constructor(tag: String, private val showResponse: Boolean = false) :
    Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logForRequest(request)
        val response = chain.proceed(request)
        return logForResponse(response)
    }

    private fun logForResponse(response: Response): Response {
        try {

            Logger.e("Response's log")

            val builder = response.newBuilder()
            val clone = builder.build()

            Logger.i(
                "url : ${clone.request().url()} \n" +
                        "code : ${clone.code()}\n" +
                        "protocol : ${clone.protocol()}"
            )

            if (!TextUtils.isEmpty(clone.message()))

                Logger.i("message : " + clone.message())

            if (showResponse) {
                var body = clone.body()
                if (body != null) {
                    val mediaType = body.contentType()
                    if (mediaType != null) {

                        Logger.i("ResponseBody's contentType : $mediaType")

                        if (isText(mediaType)) {
                            val resp = body.string()

                            Logger.i("ResponseBody's content : $resp")

                            body = ResponseBody.create(mediaType, resp)
                            return response.newBuilder().body(body).build()
                        } else {
                            Logger.i("ResponseBody's content : " + " maybe [file part] , too large too print , ignored!")
                        }
                    }
                }
            }

        } catch (e: Exception) {
            //            e.printStackTrace();
        }

        return response
    }

    private fun logForRequest(request: Request) {
        try {
            val url = request.url().toString()
            val headers = request.headers()

            Logger.e(" Request's log \n method : ${request.method()} \n url : $url")

            if (headers != null && headers.size() > 0) {
                Logger.i("headers : $headers")
            }
            val requestBody = request.body()
            if (requestBody != null) {
                val mediaType = requestBody.contentType()
                if (mediaType != null) {

                    Logger.i("RequestBody's contentType : $mediaType")

                    if (isText(mediaType)) {
                        Logger.i("RequestBody's content : " + bodyToString(request))
                    } else {
                        Logger.i("RequestBody's content : " + " maybe [file part] , too large too print , ignored!")
                    }
                }
            }
        } catch (e: Exception) {
            //            e.printStackTrace();
        }

    }

    private fun isText(mediaType: MediaType): Boolean {
        if (mediaType.type() != null && mediaType.type() == "text") {
            return true
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype() == "json" ||
                mediaType.subtype() == "xml" ||
                mediaType.subtype() == "html" ||
                mediaType.subtype() == "webviewhtml" ||
                mediaType.subtype() == "x-www-form-urlencoded"
            )
                return true
        }
        return false
    }

    private fun bodyToString(request: Request): String {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body()?.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "something error when show requestBody."
        }

    }

}