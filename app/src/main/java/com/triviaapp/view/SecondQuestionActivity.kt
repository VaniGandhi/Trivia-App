package com.triviaapp.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.getDate
import com.getTime
import com.triviaapp.adapters.ColorsAdapter
import com.triviaapp.database.Dao
import com.triviaapp.database.Database
import com.triviaapp.model.ColorModel
import com.triviaapp.model.DatabaseModel
import com.showToast
import com.triviaapp.R
import com.triviaapp.database.Model
import com.triviaapp.databinding.ActivitySecondQuestionBinding
import com.triviaapp.viewModel.SaveDataViewModel
import com.triviaapp.viewModelFactory.SaveDataViewModelFactory
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class SecondQuestionActivity : AppCompatActivity(), ColorsAdapter.onItemClick {

    var binding:ActivitySecondQuestionBinding?=null
    var model: DatabaseModel?=null
    var answer:String?=null
    private lateinit var dao: Dao
    private  var viewModel:SaveDataViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_second_question)
        init()
    }

    private  fun init()
    {
        //****************Intializing dao ****************//
        dao = Database.getDatabase(this).dao()
        //****************Intializing viewModel ****************//

        val viewModelFactory =
            SaveDataViewModelFactory(dao,application)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(SaveDataViewModel::class.java)
        //****************Getting data from intent ****************//
        if(intent!=null)
        {
            model= intent.getSerializableExtra("data") as DatabaseModel?
        }
        //****************Adding to list ****************//

        val colorlist=ArrayList<ColorModel>()
        colorlist.add(ColorModel("A) White", false))
        colorlist.add(ColorModel("B) Yellow", false))
        colorlist.add(ColorModel("C) Orange", false))
        colorlist.add(ColorModel("D) Green", false))

        //****************Setting adapter ****************//
        val adapter=ColorsAdapter(this, colorlist)
        adapter.setOnClickListener(this)
        binding?.rvColors?.adapter=adapter

        binding!!.btContinue.setOnClickListener(View.OnClickListener {
            if(answer!=null)
            {
                //****************Saving data in room database*********************//
                model?.answer2=answer
                val databaseModel=Model(model?.name!!, model?.answer1!!, model?.answer2!!,
                    getDate(Calendar.getInstance().time)!!, getTime(Calendar.getInstance().time)!!
                )
                viewModel?.saveData(databaseModel)

                //****************moving to next activity**********************//
                val intent= Intent(this, SummaryActivity::class.java)
                intent.putExtra("data",model)
                startActivity(intent)
                finish()


            }
            else{
               showToast("Please select answer ", Toast.LENGTH_SHORT)
            }

        })

    }

    override fun onItemClickListener(list: ArrayList<String>) {
        answer=list.joinToString()

    }
}