package com.plinko.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plinko.screen.game.GameScreen
import com.plinko.screen.menu.MenuScreen
import com.plinko.screen.records.RecordsContent
import com.plinko.screen.settings.SettingsContent
import com.plinko.screen.shop.ShopContent
import com.plinko.screen.splash.SplashContent
import com.plinko.ui.elements.OnLifecycleEvent
import org.lighthousegames.logging.logging

private val log = logging("AppNavigation")

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    OnLifecycleEvent {
        log.e { "LifecycleEvent: $it" }
    }
    NavHost(
        navController = navController,
        startDestination = NavigationConstants.SPLASH
    ) {
        composable(NavigationConstants.SPLASH) {
            SplashContent {
                navController.navigate(NavigationConstants.MENU) {
                    popUpTo(NavigationConstants.SPLASH) {
                        inclusive = true
                    }
                }
            }
        }
        composable(NavigationConstants.MENU) {
            MenuScreen {screenRote->
                navController.navigate(screenRote)
            }
        }
        composable(NavigationConstants.GAME) {
            GameScreen {
                navController.popBackStack()
            }
        }

        composable(NavigationConstants.SHOP) {
            ShopContent {
                navController.popBackStack()
            }

        }
        composable(NavigationConstants.RECORDS) {
            RecordsContent { navController.popBackStack() }
        }
        composable(NavigationConstants.SETTINGS) {
            SettingsContent {
                navController.popBackStack()
            }
        }

    }
}

object NavigationConstants {
    const val MENU = "menu"
    const val GAME = "game"
    const val SETTINGS = "settings"
    const val RECORDS = "records"
    const val SPLASH = "splash"
    const val SHOP = "shop"
}