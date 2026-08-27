"""
Esqueleto del motor. Por ahora solo prueba que el puente Kotlin <-> Python
(Chaquopy) funciona de punta a punta. El motor real (los patrones de
detección, la IA, la confirmación de suscripción, etc.) se porta acá en la
siguiente etapa, una vez confirmado que esto compila y corre en un celular
de verdad.
"""

import sys


def saludo():
    return f"Motor Python vivo — {sys.version.split()[0]}"
