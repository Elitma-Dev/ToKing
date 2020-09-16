package br.com.prado.toking

import android.app.Application
import br.com.prado.toking.di.appModule
import org.koin.core.context.startKoin

@Suppress("unused")
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}
