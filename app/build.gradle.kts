plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.route_task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.route_task"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.v180)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material.v150)
    implementation(libs.androidx.constraintlayout)
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //flow
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.androidx.material)
    // Glide
    implementation(libs.glide)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.navigation.fragment)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)

    // Rounded ImageView
    implementation(libs.roundedimageview)
    implementation(libs.squareup.picasso)
    //retrofit
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //prefs store
    implementation (libs.androidx.datastore.preferences)

    // RecyclerView
    implementation(libs.androidx.recyclerview)

    // Material Design
    implementation(libs.material)

    // Activity
    implementation(libs.androidx.activity)

    // ConstraintLayout
    implementation(libs.androidx.constraintlayout)

   //shimmer effect
    implementation(libs.shimmer)

    //rounded image
    implementation(libs.roundedimageview)

    //glide
    implementation(libs.glide)
    //fragment
    implementation (libs.androidx.appcompat.v131)
    implementation (libs.androidx.fragment)
    implementation (libs.androidx.constraintlayout.v210)
    implementation (libs.material.v140)
    implementation (libs.androidx.databinding.runtime)
    implementation(libs.androidx.navigation.fragment)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.fragment.ktx)
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
