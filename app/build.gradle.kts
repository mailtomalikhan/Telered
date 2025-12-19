plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.telered.tv"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.telered.tv"
        minSdk = 23
        targetSdk = 36
        versionCode = 2
        versionName = "1.1"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.leanback)
    implementation(libs.glide)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.cardview)
    implementation ("com.google.android.exoplayer:exoplayer:2.19.1")
}