package com.plinko.screen.records

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.plinko.navigation.NavigationConstants
import com.plinko.screen.menu.MenuScreen
import com.plinko.screen.menu.MenuViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RecordsContent(onBack: () -> Unit) {
    val viewModel = koinViewModel<RecordViewModel>()
    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            "Records Screen",
            modifier = Modifier.wrapContentSize().align(Alignment.Center).clickable {
                onBack()
            })

    }
}