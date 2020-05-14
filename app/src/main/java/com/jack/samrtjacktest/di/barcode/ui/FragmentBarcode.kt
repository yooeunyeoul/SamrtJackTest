package com.jack.samrtjacktest.di.barcode.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.integration.android.IntentIntegrator
import com.jack.samrtjacktest.R
import com.jack.samrtjacktest.data.SendData
import com.jack.samrtjacktest.databinding.FragmentBarcodeMainBinding
import com.jack.samrtjacktest.di.injectViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_barcode_main.*
import javax.inject.Inject

class FragmentBarcode : DaggerFragment() {

    private lateinit var viewModel: BarcodeViewModel
    private lateinit var binding: FragmentBarcodeMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_barcode_main,
            container,
            false

        )
        viewModel = injectViewModel(viewModelFactory)

        barcodeInit()

        subscribeText()

        return binding.root
    }

    private fun subscribeText() {

        viewModel.resultText.observe(this, Observer {
            binding.resultText = it
        })
    }

    private fun barcodeInit() {
        val intentIntegrator = IntentIntegrator.forSupportFragment(this@FragmentBarcode)
        intentIntegrator.setCameraId(0)
        intentIntegrator.setBeepEnabled(false);//바코드 인식시 소리
        intentIntegrator.setOrientationLocked(false)
        intentIntegrator.initiateScan()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IntentIntegrator.REQUEST_CODE) {

            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            val sendData = SendData(value = result.contents, name = result.formatName, phone = "")

            binding.sendData = sendData

            viewModel.sendData(
                name = result.formatName,
                phone = "010-5555-0000",
                value = "ddd"
            )

            Log.i("TAG", ">>> result.getContents()   :  " + result.contents);
            Log.i("TAG", ">>> result.getFormatName()   :  " + result.formatName);

        }
    }


}