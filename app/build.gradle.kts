plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.kotlin.ksp)
}

android {
    namespace = "com.xheghun.kotlincoroutines"
    compileSdk = 34

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.xheghun.kotlincoroutines"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.swipetorefresh)
    implementation(libs.androidx.lifecycle.viewmodel)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.logging.interceptor)
    implementation(libs.squareup.retrofit.converter)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.kotlin)
    ksp(libs.androidx.room.compiler)

    implementation(libs.koin.core)
    implementation(libs.koin.android)

    implementation(libs.bumptech.glide)
    annotationProcessor(libs.bumptech.glide.compiler)

    testImplementation(libs.nhaarman.mockito)
    testImplementation(libs.kotlinx.coroutines)
    testImplementation(libs.powermock.module)
    testImplementation(libs.powermock.mockito)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}