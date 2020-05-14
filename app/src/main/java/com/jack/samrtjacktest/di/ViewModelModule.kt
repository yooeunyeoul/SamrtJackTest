package com.jack.samrtjacktest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jack.samrtjacktest.di.barcode.ui.BarcodeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BarcodeViewModel::class)
    abstract fun bindBarCodeViewModel(viewModel: BarcodeViewModel): ViewModel

    /**
     * Inject constructor 로 주입받음
     */
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
