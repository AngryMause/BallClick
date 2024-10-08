package com.plinko

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.multiplatform.lifecycle.LifecycleTracker
import com.multiplatform.lifecycle.LocalLifecycleTracker
import com.multiplatform.lifecyle.LifecycleComposeUIVCDelegate
import com.plinko.di.initKoin
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {
    val lifecycleTracker = LifecycleTracker()
    return ComposeUIViewController({
        delegate = LifecycleComposeUIVCDelegate(lifecycleTracker)
    }) {
        CompositionLocalProvider(LocalLifecycleTracker provides lifecycleTracker) {
            App()
        }
    }
}

fun initSingleComponent() {
    initKoin()
}