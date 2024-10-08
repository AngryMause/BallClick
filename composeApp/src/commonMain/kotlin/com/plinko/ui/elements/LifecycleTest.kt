package com.plinko.ui.elements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.multiplatform.lifecycle.LifecycleEvent
import com.multiplatform.lifecycle.LifecycleObserver
import com.multiplatform.lifecycle.LocalLifecycleTracker

@Composable
 fun OnLifecycleEvent(lifeCycle: (LifecycleEvent) -> Unit) {
    val lifecycleTracker = LocalLifecycleTracker.current
    DisposableEffect(Unit) {
        val listener =
            object : LifecycleObserver {
                override fun onEvent(event: LifecycleEvent) {
                    lifeCycle(event)
                }
            }
        lifecycleTracker.addObserver(listener)
        onDispose {
            lifecycleTracker.removeObserver(listener)
        }
    }
}