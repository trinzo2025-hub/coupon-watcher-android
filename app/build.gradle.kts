plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.chaquo.python")
}

android {
    namespace = "com.trinzo.couponwatcher"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.trinzo.couponwatcher"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.1-esqueleto"

        // El intérprete de Python es un componente nativo: hay que decir
        // para qué arquitecturas de CPU se empaqueta. Con estas cuatro se
        // cubre prácticamente cualquier celular Android actual (el Redmi
        // Note 13 Pro es arm64-v8a).
        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a", "x86_64")
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

chaquopy {
    defaultConfig {
        // Python 3.10 (versión por defecto de Chaquopy 17.x).
        version = "3.10"
        pip {
            // Todas puras-Python, sin extensiones nativas: livianas y
            // confiables de empaquetar. Es el mismo motor de detección que
            // ya usa la versión de escritorio, sin cambios en esta parte.
            install("requests")
            install("beautifulsoup4")
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    // OCR 100% en el dispositivo, gratis, sin internet — reemplaza a
    // Tesseract (que no se puede empaquetar fácil en Android).
    implementation("com.google.mlkit:text-recognition:16.0.1")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
