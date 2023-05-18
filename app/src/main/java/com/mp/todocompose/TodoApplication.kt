package com.mp.todocompose

import android.app.Application
import com.mp.todocompose.data.AppContainer
import com.mp.todocompose.data.AppDataContainer

class TodoApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
