package com.jack.samrtjacktest.barcode.data

import com.jack.samrtjacktest.api.ApiService
import com.jack.samrtjacktest.data.SendData
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BarcodeRepository @Inject internal constructor(private val service: ApiService) {

    public fun postData(name: String, phoneNum: String, value: String) : Single<Any> {
        return service.postData(SendData(value,name,phoneNum) )
    }

}