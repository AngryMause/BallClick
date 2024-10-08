package com.plinko.screen.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plinko.screen.settings.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ShopContent(onBack: () -> Unit) {
    val viewModel = koinViewModel<ShopViewModel>()
    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            "ShopContent Screen",
            modifier = Modifier.wrapContentSize().align(Alignment.Center).clickable {
                onBack()
            })

    }
}