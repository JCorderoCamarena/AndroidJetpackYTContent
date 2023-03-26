plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jcamarena.navigationincompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.jcamarena.navigationincompose"
        minSdk = 24
        targetSdk = 33
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.android.core.ktx)
    implementation(libs.lifecycle.runtime)
    implementation(libs.activity.compose)
    implementation( platform(libs.compose.bom) )
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.material3)
    implementation(libs.compose.navigation)
}

dependencies {
    implementation(project(mapOf("path" to ":authentication")))
    implementation(project(mapOf("path" to ":home")))
    testImplementation(libs.test.junit)
    testImplementation(libs.test.junit.ext)
    testImplementation(libs.test.espresso.core)
    androidTestImplementation( platform(libs.compose.bom) )
    androidTestImplementation(libs.test.junit.ui)
    debugImplementation(libs.test.compose.ui.tooling)
    debugImplementation(libs.test.compose.ui.manifest)
}
