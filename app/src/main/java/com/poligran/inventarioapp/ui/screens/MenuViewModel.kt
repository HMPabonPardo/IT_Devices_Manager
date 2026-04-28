package com.poligran.inventarioapp.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class MenuNavigationEvent {
    object NavigateToLogin : MenuNavigationEvent()
    data class NavigateToSection(val section: String) : MenuNavigationEvent()
}

class MenuViewModel : ViewModel() {
    
    private val _navigationEvent = MutableStateFlow<MenuNavigationEvent?>(null)
    val navigationEvent: StateFlow<MenuNavigationEvent?> = _navigationEvent.asStateFlow()
    
    // Usuario estático
    val currentUser = UserInfo(
        name = "Juan Espinosa",
        email = "jespinosa@poligran.edu.co",
        role = "Desarrollador"
    )
    
    fun onMenuItemClicked(section: String) {
        _navigationEvent.value = MenuNavigationEvent.NavigateToSection(section)
        // Resetear el evento después de procesarlo
        _navigationEvent.value = null
    }
    
    fun onLogout() {
        _navigationEvent.value = MenuNavigationEvent.NavigateToLogin
    }
    
    fun resetNavigationEvent() {
        _navigationEvent.value = null
    }
}
