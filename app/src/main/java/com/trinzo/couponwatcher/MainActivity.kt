package com.trinzo.couponwatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

/**
 * Punto de entrada de la ETAPA 1 (esqueleto): solo confirma que el
 * intérprete de Python embebido (Chaquopy) arranca y responde de verdad
 * dentro de la app compilada — antes de portar el motor real de detección
 * y armar las pantallas definitivas (bandeja de pendientes, buscador,
 * configuración).
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        setContent {
            MaterialTheme {
                Surface {
                    PantallaDePrueba()
                }
            }
        }
    }
}

@Composable
fun PantallaDePrueba() {
    var mensaje by remember { mutableStateOf("Iniciando el motor Python...") }

    remember {
        val py = Python.getInstance()
        val modulo = py.getModule("motor")
        mensaje = modulo.callAttr("saludo").toString()
        true
    }

    Box(modifier = Modifier.padding(24.dp)) {
        Text(text = "Coupon Watcher (esqueleto)\n\n$mensaje")
    }
}
