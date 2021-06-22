package com.triviaapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.triviaapp.R
import com.triviaapp.adapters.HistoryAdapter
import com.triviaapp.database.Dao
import com.triviaapp.database.Database
import com.triviaapp.databinding.ActivityHistoryBinding
import com.triviaapp.model.DatabaseModel
import com.triviaapp.viewModelFactory.SaveDataViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {
    private lateinit var dao: Dao
    var binding:ActivityHistoryBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this, R.layout.activity_history)
        init()
    }
    private  fun init()
    {

        //****************Intializing dao ****************//
        dao = Database.getDatabase(this).dao()
        //****************Getting the list of activities saved****************//
        GlobalScope.launch(Dispatchers.IO) {

            val datalist = arrayListOf<DatabaseModel>()

            val list = dao.getdata()

            for (i in list.indices) {
                datalist.add(list.get(i))

            }
            withContext(Dispatchers.Main) {
                //***************Setting adapter****************//
                val adapter = HistoryAdapter(this@HistoryActivity, datalist)
                binding!!.rvHistory.adapter = adapter

            }

        }





    }
}