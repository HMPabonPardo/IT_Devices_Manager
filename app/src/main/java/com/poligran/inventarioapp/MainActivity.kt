package com.poligran.inventarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.poligran.inventarioapp.ui.screens.*
import com.poligran.inventarioapp.ui.theme.ITDevicesManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITDevicesManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

sealed class AppScreen {
    object Login : AppScreen()
    object Menu : AppScreen()
    object Profile : AppScreen()
    object Assignment : AppScreen()
    object Inventory : AppScreen()
    object Transactions : AppScreen()
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf<AppScreen>(AppScreen.Login) }

    when (currentScreen) {
        AppScreen.Login -> {
            LoginScreen(
                onLoginClick = { usuario, contrasena ->
                    if (usuario.isNotBlank() && contrasena.isNotBlank()) {
                        currentScreen = AppScreen.Menu
                    }
                }
            )
        }

        AppScreen.Menu -> {
            MenuScreen(
                onLogout = { currentScreen = AppScreen.Login },
                onProfileClick = { currentScreen = AppScreen.Profile },  // ← AGREGAR ESTO
                onMenuItemClick = { section ->
                    currentScreen = when (section) {
                        "assignment" -> AppScreen.Assignment
                        "inventory" -> AppScreen.Inventory
                        "transactions" -> AppScreen.Transactions
                        else -> AppScreen.Menu
                    }
                }
            )
        }

        AppScreen.Profile -> {
            ProfileScreen(
                onBackClick = { currentScreen = AppScreen.Menu }
            )
        }

        AppScreen.Assignment -> {
            AssignmentScreen(
                onBackClick = { currentScreen = AppScreen.Menu }
            )
        }

        AppScreen.Inventory -> {
            InventoryScreen(
                onBackClick = { currentScreen = AppScreen.Menu }
            )
        }

        AppScreen.Transactions -> {
            TransactionsScreen(
                onBackClick = { currentScreen = AppScreen.Menu }
            )
        }
    }
}