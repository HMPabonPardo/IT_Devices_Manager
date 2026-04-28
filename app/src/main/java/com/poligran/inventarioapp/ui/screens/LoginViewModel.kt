package com.poligran.inventarioapp.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.poligran.inventarioapp.utils.ValidationUtils

/**
 * Estados posibles del login
 */
sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val usuario: String) : LoginState()
    data class Error(val mensaje: String) : LoginState()
}

/**
 * ViewModel para manejar la lógica de la pantalla de login
 * Sigue el patrón MVVM (Model-View-ViewModel)
 */
class LoginViewModel : ViewModel() {
    
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()
    
    private val _usuario = MutableStateFlow("")
    val usuario: StateFlow<String> = _usuario.asStateFlow()
    
    private val _contrasena = MutableStateFlow("")
    val contrasena: StateFlow<String> = _contrasena.asStateFlow()
    
    private val _usuarioError = MutableStateFlow<String?>(null)
    val usuarioError: StateFlow<String?> = _usuarioError.asStateFlow()
    
    private val _contrasenaError = MutableStateFlow<String?>(null)
    val contrasenaError: StateFlow<String?> = _contrasenaError.asStateFlow()
    
    fun onUsuarioChanged(nuevoValor: String) {
        _usuario.value = nuevoValor
        _usuarioError.value = null
    }
    
    fun onContrasenaChanged(nuevoValor: String) {
        _contrasena.value = nuevoValor
        _contrasenaError.value = null
    }
    
    /**
     * Valida los campos y realiza el login
     * En una app real, aquí se haría la llamada a un servicio de autenticación
     */
    fun login() {
        // Validar campos
        _usuarioError.value = ValidationUtils.getUsuarioErrorMessage(_usuario.value)
        _contrasenaError.value = ValidationUtils.getContrasenaErrorMessage(_contrasena.value)
        
        if (_usuarioError.value == null && _contrasenaError.value == null) {
            _loginState.value = LoginState.Loading
            
            // Simular llamada a servidor
            // En una app real, usar Retrofit, Room, o similar
            try {
                // TODO: Aquí va la llamada a tu API
                val usuarioAutenticado = _usuario.value
                
                // Simular delay de red
                Thread.sleep(1500)
                
                _loginState.value = LoginState.Success(usuarioAutenticado)
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(
                    e.message ?: "Error desconocido durante el login"
                )
            }
        }
    }
    
    /**
     * Resetea el estado a Idle para poder intentar nuevamente
     */
    fun resetState() {
        _loginState.value = LoginState.Idle
    }
    
    /**
     * Limpia todos los campos
     */
    fun clearFields() {
        _usuario.value = ""
        _contrasena.value = ""
        _usuarioError.value = null
        _contrasenaError.value = null
        _loginState.value = LoginState.Idle
    }
}
