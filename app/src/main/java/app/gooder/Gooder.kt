package app.gooder

import android.app.Application
import app.gooder.initializers.AppInitializer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Gooder : Application() {

    @Inject
    lateinit var initializers: AppInitializer

    override fun onCreate() {
        super.onCreate()
        initializers.init()
    }
}
