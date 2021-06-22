package com.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.triviaapp.adapters.CricketerAdapter
import com.triviaapp.model.DatabaseModel
import com.triviaapp.R
import com.triviaapp.database.Model
import com.triviaapp.databinding.ActivityFirstQuestionBinding

class FirstQuestionActivity : AppCompatActivity(), CricketerAdapter.onItemClick {

    var binding:ActivityFirstQuestionBinding?=null
    var answer:String?=null
    var model: DatabaseModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_question)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_first_question)
        init()


    }

    private  fun init()
    {
        //****************Getting data from intent ****************//
        if(intent!=null)
        {
            model= intent.getSerializableExtra("data") as DatabaseModel?
        }
        //****************Adding to list ****************//
        val answerlist=ArrayList<String>()
        answerlist.add("A) Sachin Tendulkar")
        answerlist.add("B) Virat Kohli")
        answerlist.add("C) Adam Gilchirst")
        answerlist.add("D) Jacques Kallis")

        //****************Setting adapter ****************//
        val adapter=CricketerAdapter(this, answerlist)
        adapter.setOnClickListener(this)
        binding!!.rvcricketers.adapter=adapter


        //****************Saving data and moving to next activity**********************//
        binding?.btContinue?.setOnClickListener(View.OnClickListener {
            if (answer != null) {
                model?.answer1=answer
                val intent= Intent(this, SecondQuestionActivity::class.java)
                intent.putExtra("data",model)
                startActivity(intent)
                finish()



            } else {
                Toast.makeText(this, "Please select answer", Toast.LENGTH_SHORT).show()
            }
        })




    }

    override fun onItemClickListener(string: String) {
        answer=string
    }


}