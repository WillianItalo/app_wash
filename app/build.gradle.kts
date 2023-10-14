plugins {
    id("com.android.application")
}

android {
    namespace = "com.aula.wash.it"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.aula.wash.it"
        minSdk = 33
        targetSdk = 33
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
}

dependencies {

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("androidx.media3:media3-session:1.1.1")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.23")


    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.27")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.activity:activity:1.4.0")
    implementation ("androidx.fragment:fragment:1.3.6")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

}