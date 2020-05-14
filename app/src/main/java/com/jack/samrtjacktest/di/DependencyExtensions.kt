package com.jack.samrtjacktest.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

// inline + reified 조합은 해당 함수가 호출되는 모든 곳에 바이트코드를 복사하도록 만든다. 해당 함수가 호출되면 T로 사용된 실제 타입을 알고 만들어진 바이트코드를 직접 클래스에 대응되도록 만들어줌.
// 예 myVar is T는 myVar is String 이 될 수 있다.
inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}