plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.mbh.moviebrowser"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mbh.moviebrowser"

        minSdk = 28
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"

        buildConfigField(type = "String", name = "API_KEY", value = "\"3026a59c471f4497650a2fa46a1555cd\"")

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
        jvmTarget = JavaLanguageVersion.of(17).toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Compiler
    }
}

dependencies {
    // Core
    implementation(Android.Core.Kotlin)
    implementation(Android.Core.KotlinKtx)

    // Compose
    implementation(platform(Android.UI.Compose.BOM))
    implementation(Android.UI.Compose.Activity)
    implementation(Android.UI.Compose.Navigation)
    implementation(Android.UI.Compose.Preview)
    implementation(Android.UI.Compose.Tooling)
    implementation(Android.UI.Compose.ViewModel)
    implementation(Android.UI.Compose.Material)
    implementation(Android.UI.Coil.Coil)
    implementation(Android.UI.Coil.CoilCompose)

    // Navigation
    implementation(Android.Navigation.Fragment)
    implementation(Android.Navigation.UI)

    // Data
    implementation(Modules.Data.Retrofit)
    implementation(Modules.Data.RetrofitConverter)
    implementation(Modules.Data.DataStore)
    implementation(Modules.Data.Room)
    implementation(Modules.Data.RoomKtx)
    implementation(Modules.Data.OkhttpLogger)

    // Coroutines
    implementation(Android.Core.Coroutines)

    // DI
    implementation(Modules.DI.Dagger)

    // Utils
    implementation(Modules.Utils.Gson)

    // Kapt
    kapt(Modules.Annotation.Dagger)
    kapt(Modules.Annotation.Room)

    implementation(project(MovieBrowser.Core.Data))
    implementation(project(MovieBrowser.Core.CommonUI))
    implementation(project(MovieBrowser.Core.Network))
    implementation(project(MovieBrowser.Core.Repository))

    implementation(project(MovieBrowser.Page.Landing))
    implementation(project(MovieBrowser.Page.Detail))

}
