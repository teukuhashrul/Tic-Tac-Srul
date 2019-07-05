package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    val x = "X"
    val o = "O"

    val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButton()
        Toast.makeText(applicationContext, presenter.getTurn()+" Turn !", Toast.LENGTH_SHORT).show()
    }

    fun initButton(): Unit{
        val btn_1 = findViewById(R.id.btn_1) as Button
        btn_1.setOnClickListener{
            toggleButton(btn_1 , x)
        }
        val btn_2 = findViewById(R.id.btn_2) as Button
        btn_2.setOnClickListener{
           toggleButton(btn_2 , x)
        }
        val btn_3 = findViewById(R.id.btn_3) as Button
        btn_3.setOnClickListener{
            toggleButton(btn_3, x)
        }

        val btn_4 = findViewById(R.id.btn_4) as Button
        btn_4.setOnClickListener{
            toggleButton(btn_4, x)
        }

        val btn_5 = findViewById(R.id.btn_5) as Button
        btn_5.setOnClickListener{
            toggleButton(btn_5,x)
        }

        val btn_6 = findViewById(R.id.btn_6) as Button
        btn_6.setOnClickListener{
            toggleButton(btn_6,x)
        }

        val btn_7 = findViewById(R.id.btn_7) as Button
        btn_7.setOnClickListener{
            toggleButton(btn_7, x)
        }

        val btn_8 = findViewById(R.id.btn_8) as Button
        btn_8.setOnClickListener{
            toggleButton(btn_8, x)
        }
        val btn_9 = findViewById(R.id.btn_9) as Button
        btn_9.setOnClickListener{
            toggleButton(btn_9, x)
        }
    }

    fun toggleButton(btn: Button, sign: String): Unit{
        btn.setText(sign)
    }


    fun takeTurn(): Unit{
        // ask whose turn it is

        // update data on model

        //
    }









}
