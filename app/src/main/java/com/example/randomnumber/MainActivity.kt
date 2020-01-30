package com.example.randomnumber

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollButton)
        val textOutput = findViewById<TextView>(R.id.textOutput)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val limitNumber = findViewById<TextView>(R.id.limitNumber)

        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(sk: SeekBar?, progress: Int, p2: Boolean) {
                limitNumber.text = progress.toString()
            }

            override fun onStartTrackingTouch(sk: SeekBar?) {
                limitNumber.text = sk?.progress.toString()
            }

            override fun onStopTrackingTouch(sk: SeekBar?) {
                limitNumber.text = sk!!.progress.toString()
            }

        })



        rollButton.setOnClickListener {
            if (seekBar.progress != 0){
                val rand = Random.nextInt(seekBar.progress)
                textOutput.text = rand.toString()
            }
            else{
                textOutput.text = "Limit is 0"
            }

        }
    }
}
