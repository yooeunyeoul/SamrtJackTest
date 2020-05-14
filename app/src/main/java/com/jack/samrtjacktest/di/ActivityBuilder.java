package com.jack.samrtjacktest.di;

import com.jack.samrtjacktest.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract
class ActivityBuilder {

    @ContributesAndroidInjector(modules = FragmentProvider.class)
    abstract MainActivity bindMainActivity();

}