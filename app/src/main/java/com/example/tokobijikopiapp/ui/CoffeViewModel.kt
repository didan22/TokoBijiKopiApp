package com.example.tokobijikopiapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tokobijikopiapp.model.Coffe
import com.example.tokobijikopiapp.repository.CoffeRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CoffeViewModel(private val repository: CoffeRepository): ViewModel() {
    val allCoffe: LiveData<List<Coffe>> = repository.allCoffe.asLiveData()

    fun insert(coffe: Coffe) = viewModelScope.launch {
        repository.insertCoffe(coffe)
    }

    fun delete(coffe: Coffe) = viewModelScope.launch {
        repository.deleteCoffe(coffe)
    }

    fun update(coffe: Coffe) = viewModelScope.launch {
        repository.updateCoffe(coffe)
    }
}

class CoffeViewModelFactory(private val repository:CoffeRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((CoffeViewModel::class.java))) {
            return CoffeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}