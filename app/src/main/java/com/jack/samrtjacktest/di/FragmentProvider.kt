package com.jack.samrtjacktest.di

import com.jack.samrtjacktest.barcode.ui.FragmentBarcode
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider{

    @ContributesAndroidInjector
    abstract fun contributeBarcodeFragment() : FragmentBarcode
}