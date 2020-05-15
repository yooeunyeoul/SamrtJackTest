package com.jack.samrtjacktest.barcode.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jack.samrtjacktest.data.SendData
import com.jack.samrtjacktest.barcode.data.BarcodeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BarcodeViewModel @Inject constructor(private val repository: BarcodeRepository) :
    ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()


    val resultText = MutableLiveData<String>()


    public fun sendData(name: String, phone: String, value: String) {

        disposable.add(
            repository.postData(name, phone, value).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<Any>() {
                    override fun onSuccess(t: Any) {
                        resultText.value = t.toString()

                    }

                    override fun onError(e: Throwable) {
                        resultText.value = e.message
                    }

                })
        )
    }

}