# Coupon Watcher — Android

## Estado actual: ETAPA 1 — esqueleto

Este primer commit **no tiene el motor de detección real todavía**. Es a
propósito: antes de portar toda la lógica (patrones de cupón, IA, OCR,
confirmación de suscripción), hay que confirmar que la base técnica
compila y corre en un celular real:

- Proyecto Android + Kotlin + Jetpack Compose.
- Chaquopy (Python embebido) funcionando de punta a punta: la pantalla
  llama a una función Python (`motor.saludo()`) y muestra el resultado.
- Compilación automática en la nube vía GitHub Actions (no hace falta
  Android Studio instalado en ninguna compu).

Si esta pantalla muestra "Motor Python vivo — 3.10.x" en el celular, la
base funciona y se puede seguir con el resto.

## Cómo conseguir el APK

1. Andá a la pestaña **Actions** de este repositorio.
2. Entrá a la corrida más reciente de "Compilar APK".
3. Al final de la página, en "Artifacts", descargá `coupon-watcher-debug-apk`.
4. Es un .zip que contiene `app-debug.apk` — instalalo en el celular
   (puede pedir habilitar "instalar apps de orígenes desconocidos" la
   primera vez, es normal para un APK que no viene de Play Store).

## Próximas etapas

1. Portar el motor de detección (`coupon_watcher_app.py` → módulos Python
   dentro de `app/src/main/python/`, sacando Tkinter/Playwright).
2. Pantalla de bandeja de pendientes (tarjetas, deslizar para
   Agregado/Descartado).
3. Integrar ML Kit Text Recognition para OCR de imágenes.
4. Pantalla de búsqueda de cupones por tienda (IA + búsqueda web).
5. Pantalla de configuración (clave de Gmail/IA, intervalo, etc.).
6. Botón "Abrir en SimplyCodes" con el slug ya resuelto.
