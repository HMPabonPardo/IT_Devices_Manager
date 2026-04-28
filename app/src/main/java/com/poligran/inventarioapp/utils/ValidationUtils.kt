package com.poligran.inventarioapp.utils

/**
 * Extensiones para validación de campos en la aplicación
 */

object ValidationUtils {
    
    /**
     * Valida si el usuario no está vacío
     */
    fun isValidUsuario(usuario: String): Boolean {
        return usuario.isNotBlank() && usuario.length >= 3
    }
    
    /**
     * Valida si la contraseña cumple los requisitos
     */
    fun isValidContrasena(contrasena: String): Boolean {
        return contrasena.length >= 6
    }
    
    /**
     * Valida si el correo es válido
     */
    fun isValidEmail(email: String): Boolean {
        val emailRegex = """^[A-Za-z0-9+_.-]+@(.+)$""".toRegex()
        return emailRegex.matches(email)
    }
    
    /**
     * Obtiene mensaje de error para usuario
     */
    fun getUsuarioErrorMessage(usuario: String): String? {
        return when {
            usuario.isBlank() -> "El usuario es requerido"
            usuario.length < 3 -> "El usuario debe tener al menos 3 caracteres"
            else -> null
        }
    }
    
    /**
     * Obtiene mensaje de error para contraseña
     */
    fun getContrasenaErrorMessage(contrasena: String): String? {
        return when {
            contrasena.isBlank() -> "La contraseña es requerida"
            contrasena.length < 6 -> "La contraseña debe tener al menos 6 caracteres"
            else -> null
        }
    }
}
