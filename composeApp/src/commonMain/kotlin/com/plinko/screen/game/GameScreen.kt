package com.plinko.screen.game

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun GameScreen(onBack: () -> Unit) {
    val viewModel = koinViewModel<GameViewModel>()
    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            "Game Screen",
            modifier = Modifier.wrapContentSize().align(Alignment.Center).clickable {
                onBack()
            })

    }
}