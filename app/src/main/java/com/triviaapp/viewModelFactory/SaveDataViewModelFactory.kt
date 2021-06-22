package com.triviaapp.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.triviaapp.database.Dao
import com.triviaapp.viewModel.SaveDataViewModel

class SaveDataViewModelFactory  (private val dao: Dao, private val application: Application)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaveDataViewModel::class.java)) {
            return SaveDataViewModel(dao,application) as T
        }


        throw IllegalArgumentException("Unknown ViewModel class")
    }

}