package com.example.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //cannot assign immediately during declaration because nothing is allowed t o b e assigned yet
    //binding activities should only be done in the main driver class
    //other data classes are only to hold/store data and it does not use any memory
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("W123", "Ali")

        //Conventional Way
        /*val tv:TextView = findViewById(R.id.tvID)
        tv.text = student.id
        */

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //lets say idk where you want to display the details if backend and frontend are different team
        //.tvID.text = student.id
        //binding.tvName.text = student.name

        binding.myData = student

        //it = "this" in java
        //View group are the layout, like checkbox text view blah blah
        binding.btnUpdate.setOnClickListener {
            student.name = "Alex"
            //binding.tvName.text = student.name;

            //very useful when change alot of data
            binding.apply {
                invalidateAll()
            }
        }

    }
}