package com.example.tokobijikopiapp.repository

import com.example.tokobijikopiapp.dao.CoffeDao
import com.example.tokobijikopiapp.model.Coffe
import kotlinx.coroutines.flow.Flow

class CoffeRepository(private val coffeDao: CoffeDao) {
    val allCoffe: Flow<List<Coffe>> = coffeDao.getAllCoffe()

    suspend fun  insertCoffe(coffe: Coffe) {
        coffeDao.insertCoffe(coffe)
    }

    suspend fun  deleteCoffe(coffe: Coffe) {
        coffeDao.deleteCoffe(coffe)
    }

    suspend fun  updateCoffe(coffe: Coffe) {
        coffeDao.updateCoffe(coffe)
    }
}