package com.plinko.screen.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SplashContent(onGo: () -> Unit) {
    val viewModel = koinViewModel<SplashViewModel>()
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.padding(bottom = 40.dp).size(100.dp).align(Alignment.BottomCenter)
        )
        Text(
            "Splash Screen",
            modifier = Modifier.wrapContentSize().align(Alignment.Center).clickable {
                onGo()
            })

    }
}