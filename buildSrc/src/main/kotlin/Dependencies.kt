object Android {
    object Core {
        val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Android.Kotlin}"
        val KotlinKtx = "androidx.core:core-ktx:${Versions.Android.KotlinKtx}"
        val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Android.Coroutines}"
        val AppCompat = "androidx.appcompat:appcompat:${Versions.Android.AppCompat}"
        val Core = "androidx.core:core-ktx:${Versions.Android.Core}"
        val Material = "com.google.android.material:material:${Versions.Android.Material}"
    }

    object UI {
        object Compose {
            val BOM = "androidx.compose:compose-bom:${Versions.Compose.BOM}"
            val Activity = "androidx.activity:activity-compose:${Versions.Compose.Activity}"
            val Navigation = "androidx.navigation:navigation-compose:${Versions.Compose.Navigation}"
            val Preview = "androidx.compose.ui:ui-tooling-preview"
            val Tooling = "androidx.compose.ui:ui-tooling"
            val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.Viewmodel}"
            val Material = "androidx.compose.material3:material3"
        }
        object Coil {
            val Coil = "io.coil-kt:coil:${Versions.Util.Coil}"
            val CoilCompose = "io.coil-kt:coil-compose:${Versions.Util.Coil}"
        }
    }

    object Navigation {
        val Fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Compose.Navigation}"
        val UI = "androidx.navigation:navigation-ui-ktx:${Versions.Compose.Navigation}"
    }

    object Testing {
        val JUnit = "unit:junit:4.13.2"
        val JUnitExt = "androidx.test.ext:junit:1.1.5"
        val Espresso = "ndroidx.test.espresso:espresso-core:3.5.1"
    }
}

object Modules {
    object Data {
        val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.Networking.Retrofit.Retrofit}"
        val RetrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.Networking.Retrofit.RetrofitGsonConverter}"
        val DataStore = "androidx.datastore:datastore-preferences:${Versions.JetPack.Datastore}"
        val Room = "androidx.room:room-runtime:${Versions.JetPack.Room}"
        val RoomKtx = "androidx.room:room-ktx:${Versions.JetPack.Room}"
        val OkhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.Networking.OkHttp}"
    }

    object DI {
        val Dagger          = "com.google.dagger:dagger:${Versions.DI.Dagger}"
    }

    object Utils {
        val Gson            = "com.google.code.gson:gson:${Versions.Networking.Gson}"
    }

    object Annotation {
        val Dagger          = "com.google.dagger:dagger-compiler:${Versions.DI.Dagger}"
        val Room            = "androidx.room:room-compiler:${Versions.JetPack.Room}"
    }
}

object MovieBrowser {
    object Core {
        val Network = ":core:backend"
        val Data = ":core:data"
        val CommonUI = ":core:common-ui"
        val Repository = ":core:repository"
    }
    object Page {
        val Landing = ":page:landing-page"
        val Detail = ":page:detail-page"
    }
}
