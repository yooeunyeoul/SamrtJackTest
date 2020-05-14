package com.jack.samrtjacktest.api

import com.jack.samrtjacktest.data.SendData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    companion object {
        val ENDPOINT =
            "https://eq0lwb7e8e.execute-api.ap-northeast-2.amazonaws.com/"
    }

    @POST("default/android-dev-recruit")
    fun postData(
       @Body body:SendData
    ):Single<Any>


}