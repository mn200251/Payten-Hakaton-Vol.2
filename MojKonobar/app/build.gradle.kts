plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.mojkonobar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mojkonobar"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.camera:camera-core:1.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-rc01")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-rc01")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-rc01")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-rc01")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-rc01")

    // https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes
    implementation ("androidx.compose.material3:material3-window-size-class:1.2.0-alpha11")

    // https://developer.android.com/jetpack/compose/navigation
    implementation ("androidx.navigation:navigation-compose:2.7.5")

    implementation ("com.google.android.material:material:1.10.0")

    implementation ("io.coil-kt:coil:1.4.0")

    implementation ("androidx.compose.ui:ui:1.5.4") // Use the appropriate version
    implementation ("androidx.compose.ui:ui-tooling:1.5.4") // Use the appropriate version
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4") // Use the appropriate version
    implementation("androidx.compose.material:material-icons-extended")

    val camerax_version = "1.3.0-alpha04"
    implementation ("androidx.camera:camera-camera2:${camerax_version}")
    implementation ("androidx.camera:camera-lifecycle:${camerax_version}")
    implementation ("androidx.camera:camera-view:${camerax_version}")
    implementation ("com.google.mlkit:barcode-scanning:17.0.3")
    implementation ("com.google.accompanist:accompanist-permissions:0.32.0")
}