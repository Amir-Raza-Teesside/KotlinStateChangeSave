package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var name: String
    lateinit var names:TextView;

    lateinit var btn:Button;
     var counter:Int=10;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        names = findViewById<TextView>(R.id.txt)
        btn = findViewById(R.id.mbtn);


        names.text = "Hi Aamir"

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter")
            updateText()
        } else {
            // Set initial text if state is not restored
            names.text = "Hi Aamir"
        }


        btn.setOnClickListener(View.OnClickListener {


            counter++
            updateText()


        })



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)



    }

    private fun updateText() {
        // Change text based on the counter value (odd or even)
        if (counter % 2 == 0) {
            names.text = "Even"
        } else {
            names.text = "Odd"
        }
    }
}