import org.jetbrains.compose.ComposePlugin.CommonComponentsDependencies
import org.jetbrains.compose.ComposePlugin.CommonComponentsDependencies.resources
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.cocoapods)
    kotlin("plugin.serialization")
}
version="1.0"
kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("co.touchlab:stately-common:1.2.0") // Replace with the latest version
            }
        }
    }
    val xcf = XCFramework()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            xcf.add(this)
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn", "-Xobfuscate")
            linkerOpts.addAll(
                listOf(
                    "-Xlinker", "-S",
                    "-Xlinker", "-x",
                    "-Xlinker", "--strip-debug",
                    "-Xlinker", "--strip-unneeded",
                    "-Xlinker", "--strip-all"
                )
            )
        }
    }


    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            api(libs.androidx.startup)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.navigation.compose)
            implementation(libs.lifecycle.viewmodel.compose)
            implementation(compose.runtime)
            api(libs.logging)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(compose.components.resources)

            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            api(compose.components.resources)
            api(libs.datastore.preferences)
            api(libs.datastore)
            api("io.github.kevinnzou:compose-multiplatform-lifecycle-tracker:1.0.0")
            implementation(libs.kotlinx.serialization.json)
        }
    }
    cocoapods {
        version = "1.0"
        ios.deploymentTarget = "14.0"
        summary = "This is sample Summary"
        homepage = "Home URL"
        podfile = rootProject.file("iosApp/Podfile")
        pod("OneSignalXCFramework") {
            moduleName = "OneSignal"
            packageName = "OneSignal"
            version = "3.12.9"
        }
        framework {
            isStatic = true
        }
    }

}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.candy.pop.universe"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
//    packagingOptions{
//        CommonComponentsDependencies.resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}
dependencies {
    implementation(libs.androidx.media3.common)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime.compose)
}

