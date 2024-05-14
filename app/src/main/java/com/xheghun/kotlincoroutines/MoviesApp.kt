
package com.xheghun.kotlincoroutines

import android.app.Application
import com.xheghun.kotlincoroutines.di.appModule
import com.xheghun.kotlincoroutines.di.networkingModule
import com.xheghun.kotlincoroutines.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Holds and starts the application and all the dependencies.
 */
class MoviesApp : Application() {
  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidLogger()
      androidContext(this@MoviesApp)
      modules(listOf(appModule(), networkingModule(), presenterModule()))
    }
  }
}