package com.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.triviaapp.model.DatabaseModel
import com.triviaapp.R
import com.triviaapp.database.Model
import com.triviaapp.databinding.ActivityEnterNameBinding

class EnterNameActivity : AppCompatActivity() {

    var binding:ActivityEnterNameBinding?=null
    var name= ObservableField<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_enter_name)
        binding?.activity=this
        //****************Saving data and moving to next activity**********************//

        binding!!.btContinue.setOnClickListener(View.OnClickListener {
            if (!TextUtils.isEmpty(name.get())) {

                val model= DatabaseModel()
                model.name=name.get()
                val intent= Intent(this, FirstQuestionActivity::class.java)
                intent.putExtra("data",model)
                startActivity(intent)
                finish()




            } else {
                Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
            }
        })

    }


}