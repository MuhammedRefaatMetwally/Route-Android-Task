plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("de.mannodermaus.android-junit5") version "1.10.0.0"
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // Interceptor
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //prefs store
    implementation (libs.androidx.datastore.preferences)
    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.navigation.fragment)
    implementation(project(":domain"))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
   //paging
    implementation(libs.androidx.paging.common.android)
    implementation (libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material)
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)

    // (Optional) If you need "Parameterized Tests"
    testImplementation(libs.junit.jupiter.params)
    testImplementation (libs.mockk.vversion)
    testImplementation (libs.mockk.android)
    testImplementation (libs.mockk.agent)
    testImplementation(libs.mockk)
    testImplementation (libs.kotlinx.coroutines.test)

    // (Optional) If you also have JUnit 4-based tests
    testImplementation(libs.junit)
    testRuntimeOnly(libs.junit.vintage.engine)
}