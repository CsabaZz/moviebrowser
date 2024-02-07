plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.zappyware.moviebrowser.page.landing"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(Android.Core.Core)
    implementation(Android.Core.AppCompat)
    implementation(Android.Core.Material)

    // Compose
    implementation(platform(Android.UI.Compose.BOM))
    implementation(Android.UI.Compose.Activity)
    implementation(Android.UI.Compose.Navigation)
    implementation(Android.UI.Compose.Preview)
    implementation(Android.UI.Compose.Tooling)
    implementation(Android.UI.Compose.ViewModel)
    implementation(Android.UI.Compose.Material)

    // Coil
    implementation(Android.UI.Coil.Coil)
    implementation(Android.UI.Coil.CoilCompose)

    testImplementation(Android.Testing.JUnit)

    androidTestImplementation(Android.Testing.JUnitExt)
    androidTestImplementation(Android.Testing.Espresso)

    implementation(project(MovieBrowser.Core.Data))
    implementation(project(MovieBrowser.Core.CommonUI))
    implementation(project(MovieBrowser.Core.Network))
    implementation(project(MovieBrowser.Core.Repository))
}
