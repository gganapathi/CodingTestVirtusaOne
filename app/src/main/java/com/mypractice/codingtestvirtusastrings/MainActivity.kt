package com.mypractice.codingtestvirtusastrings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetDifferences.setOnClickListener {
            if (edtFirstValue.text != null && edtFirstValue.length() > 0
                && edtSecondValue.text != null && edtSecondValue.length() > 0) {
                mainViewModel.processStrings(edtFirstValue.text.toString(), edtSecondValue.text.toString())
            } else{
                Toast.makeText(this, "Please enter values", Toast.LENGTH_LONG).show()
            }
        }

        setObservers()
    }

    private fun setObservers(){
        mainViewModel.optionOneLive.observe(this, Observer {
            if(it.isEmpty())
                txtOption1.text = "Option1: null"
            else
                txtOption1.text = "Option1: $it"
        })
        mainViewModel.optionTwoLive.observe(this, Observer {
            if(it.isEmpty())
                txtOption2.text = "Option2: null"
            else
                txtOption2.text = "Option2: $it"
        })
    }
}