package com.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.triviaapp.R
import com.triviaapp.databinding.ActivitySummaryBinding
import com.triviaapp.model.DatabaseModel

class SummaryActivity : AppCompatActivity() {

    var model: DatabaseModel?=null

    var binding:ActivitySummaryBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_summary)
        init()
    }

    private  fun init()
    {

        //****************Getting data from intent ****************//
        if(intent!=null)
        {
            model= intent.getSerializableExtra("data") as DatabaseModel?
        }
        //****************Displaying the last activity data****************//
        binding.apply {
            this?.tvName?.text=model?.name
            this?.tvAns1?.text=model?.answer1
            this?.tvAns2?.text=model?.answer2
        }

        binding!!.btHistory.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        })
        binding!!.btFinish.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, EnterNameActivity::class.java))
            finish()
        })



    }
}