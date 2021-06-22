package com.triviaapp.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triviaapp.database.Dao
import com.triviaapp.database.Model
import com.isInternetConnected
import com.showInternetOff
import com.triviaapp.database.Database_Impl
import com.triviaapp.model.DatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SaveDataViewModel(private val dao: Dao, private val application: Application) : ViewModel() {
    private val TAG = this.javaClass.simpleName

    //******************Saving data in background thread**************//
    fun saveData(model: Model) {
        if (application.applicationContext.isInternetConnected()) {
            viewModelScope.launch(Dispatchers.IO) {
                dao.insertData(model)

            }


        } else {
            application.applicationContext?.showInternetOff()
        }


    }


}