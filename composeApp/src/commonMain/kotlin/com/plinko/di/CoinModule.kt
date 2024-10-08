package com.plinko.di

import com.plinko.screen.game.GameViewModel
import com.plinko.screen.menu.MenuViewModel
import com.plinko.screen.records.RecordViewModel
import com.plinko.screen.settings.SettingsViewModel
import com.plinko.screen.shop.ShopViewModel
import com.plinko.screen.splash.SplashViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val singleModule = module { }

val factoryModule = module { }

val viewModelModule = module {
    viewModel { GameViewModel() }
    viewModel { SplashViewModel() }
    viewModel { RecordViewModel() }
    viewModel { SettingsViewModel() }
    viewModel { MenuViewModel() }
    viewModel { ShopViewModel() }
}


fun initKoin() {
    // start Koin!
    // declare modules
    // load additional modules
    startKoin { modules(singleModule, factoryModule, viewModelModule) }
}