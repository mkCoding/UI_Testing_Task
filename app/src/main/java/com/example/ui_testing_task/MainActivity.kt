package com.example.ui_testing_task

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ui_testing_task.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = Intent(this,SecondActivity::class.java)


        binding.apply {
            //2 variables holding the name and text
            var name = etEnterName.text
            var message:String

            //----Functionality for handling Greeting display-----------------
            btnPrintGreeting.setOnClickListener {
                //if name is not empty print proper message
                if(name.isNotBlank()){
                    message = "Welcome $name !"
                }else{
                    message = "Please enter in some text"
                }
                tvDisplayResult.text = message
            }


            //---------Navigation functionality to Second Activity---------
            btnNext.setOnClickListener {
                startActivity(intent)
            }
        }

    }
}