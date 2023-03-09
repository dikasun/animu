package com.andikas.animu

import android.app.Application
import com.andikas.animu.core.di.*
import com.andikas.animu.di.useCaseModule
import com.andikas.animu.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AnimuApp : Application() {

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AnimuApp)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}