plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.hiltmvvmdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hiltmvvmdemo"
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
        dataBinding = true // for data binding
        viewBinding = true
    }
    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.hilt.viewmodel)
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
//    kapt(libs.hilt.compiler)


    implementation(libs.google.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp)

    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)

    implementation(libs.io.coil)
    implementation(libs.room)
    implementation(libs.room.runtime)

    implementation(libs.sdp.intuit)
    implementation(libs.ssp.intuit)

}