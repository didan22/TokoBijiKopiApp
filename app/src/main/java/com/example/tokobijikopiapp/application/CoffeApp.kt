package com.example.tokobijikopiapp.application

import android.app.Application
import com.example.tokobijikopiapp.repository.CoffeRepository

class CoffeApp: Application() {
    val database by lazy { CoffeDatabase.getDatabase(this) }
    val repository by lazy { CoffeRepository(database.coffeDao()) }
}