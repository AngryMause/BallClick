package com.plinko.screen.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plinko.navigation.NavigationConstants
import com.plinko.screen.game.GameViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MenuScreen(onOpen: (String) -> Unit) {
    val viewModel = koinViewModel<MenuViewModel>()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().align(Alignment.Center)
        ) {

            Text(
                "OpenGame Screen",
                modifier = Modifier.wrapContentSize().clickable {
                    onOpen(NavigationConstants.GAME)
                })

            Text(
                "OpenSetting Screen",
                modifier = Modifier.wrapContentSize().clickable {
                    onOpen(NavigationConstants.SETTINGS)
                })
            Text(
                "OpenShop Screen",
                modifier = Modifier.wrapContentSize().clickable {
                    onOpen(NavigationConstants.SHOP)
                })
            Text(
                "Rrecord Screen",
                modifier = Modifier.wrapContentSize().clickable {
                    onOpen(NavigationConstants.RECORDS)
                })
        }


    }
}