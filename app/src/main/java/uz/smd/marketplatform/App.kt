package uz.smd.marketplatform

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
@HiltAndroidApp
class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
//        AppDatabase.init(this)
    }
}