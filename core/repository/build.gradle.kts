plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.zappyware.moviebrowser.repository"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
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
        jvmTarget = JavaLanguageVersion.of(17).toString()
    }
}

dependencies {
    implementation(Android.Core.Coroutines)
    implementation(Modules.DI.Dagger)

    implementation(project(MovieBrowser.Core.Data))
    implementation(project(MovieBrowser.Core.CommonUI))
    implementation(project(MovieBrowser.Core.Network))
}
