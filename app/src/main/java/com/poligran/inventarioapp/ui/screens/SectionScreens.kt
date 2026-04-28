package com.poligran.inventarioapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Modelo para dispositivos
data class Dispositivo(
    val id: String,
    val codigo: String,
    val descripcion: String,
    val icon: ImageVector
)

@Composable
fun AssignmentScreen(onBackClick: () -> Unit = {}) {
    SectionScreen(
        title = "Asignación o devolución",
        subtitle = "Escanear documentos y seriales",
        onBackClick = onBackClick,
        content = {
            Text(
                text = "Funcionalidad de Asignación o Devolución",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Esta sección permite escanear documentos y seriales para asignar o devolver equipos.",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    )
}

@Composable
fun InventoryScreen(onBackClick: () -> Unit = {}) {
    SectionScreen(
        title = "Inventario de equipos",
        subtitle = "Generación de QRs y consecutivos",
        onBackClick = onBackClick,
        content = {
            Text(
                text = "Funcionalidad de Inventario",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Esta sección permite generar QRs y consecutivos para los equipos del inventario.",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    )
}

@Composable
fun TransactionsScreen(onBackClick: () -> Unit = {}) {
    // Lista de dispositivos estáticos
    val dispositivos = listOf(
        Dispositivo(
            id = "1",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Laptop
        ),
        Dispositivo(
            id = "2",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Computer
        ),
        Dispositivo(
            id = "3",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Monitor
        ),
        Dispositivo(
            id = "4",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Laptop
        ),
        Dispositivo(
            id = "5",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Computer
        ),
        Dispositivo(
            id = "6",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Monitor
        ),
        Dispositivo(
            id = "7",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Laptop
        ),
        Dispositivo(
            id = "8",
            codigo = "Portal 123456",
            descripcion = "SIS054H • Líder de Sistemas",
            icon = Icons.Filled.Computer
        ),
    )

    SectionScreen(
        title = "Transacciones",
        subtitle = "Historial de los movimientos por documento",
        onBackClick = onBackClick,
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                // Botón de Buscar Equipo
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E40AF))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Icono de escaneo
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.2f),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.QrCode,
                                contentDescription = "Escanear",
                                modifier = Modifier.size(24.dp),
                                tint = Color.White
                            )
                        }

                        // Texto
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Buscar equipo",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Escanea el código QR",
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }

                        // Icono flecha
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Escanear",
                            modifier = Modifier
                                .size(24.dp)
                                .rotate(180f),
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Título de la lista
                Text(
                    text = "Histórico de transacciones",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Lista desplazable con LazyColumn
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(dispositivos) { dispositivo ->
                        DispositivoItem(dispositivo)
                    }
                }
            }
        }
    )
}

@Composable
fun DispositivoItem(dispositivo: Dispositivo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Color(0xFFE0E0E0)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Icono del dispositivo
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = Color(0xFF1E40AF).copy(alpha = 0.1f),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = dispositivo.icon,
                    contentDescription = dispositivo.codigo,
                    modifier = Modifier.size(32.dp),
                    tint = Color(0xFF1E40AF)
                )
            }

            // Información del dispositivo
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = dispositivo.codigo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = dispositivo.descripcion,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            // Flecha
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Ver detalles",
                modifier = Modifier
                    .size(24.dp)
                    .rotate(180f),
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun SectionScreen(
    title: String,
    subtitle: String,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E40AF))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp
                )
            }
        }

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}