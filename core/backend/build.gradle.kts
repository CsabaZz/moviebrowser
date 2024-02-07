plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.zappyware.moviebrowser.network"
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
    implementation(Modules.DI.Dagger)

    implementation(Modules.Data.Retrofit)
    implementation(Modules.Data.RetrofitConverter)
    implementation(Modules.Data.OkhttpLogger)

    implementation(project(MovieBrowser.Core.Data))
}
