package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
   private val x = "X"
   private val o = "O"

    val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButton()

        val model = Games()

        // give landing page
        landingPage()



    }

    fun initButton(): Unit{
        val btn_1 = findViewById(R.id.btn_1) as Button
        btn_1.setOnClickListener{
            if(checkCell(btn_1)){
                takeTurn(btn_1, 1)
            }

        }
        val btn_2 = findViewById(R.id.btn_2) as Button
        btn_2.setOnClickListener{
            if(checkCell(btn_2)){
                takeTurn(btn_2, 2)
            }
        }
        val btn_3 = findViewById(R.id.btn_3) as Button
        btn_3.setOnClickListener{
            if(checkCell(btn_3)){
                takeTurn(btn_3, 3)
            }
        }

        val btn_4 = findViewById(R.id.btn_4) as Button
        btn_4.setOnClickListener{
            if(checkCell(btn_4)){
                takeTurn(btn_4, 4)
            }
        }

        val btn_5 = findViewById(R.id.btn_5) as Button
        btn_5.setOnClickListener{
            if(checkCell(btn_5)){
                takeTurn(btn_5, 5)
            }
        }

        val btn_6 = findViewById(R.id.btn_6) as Button
        btn_6.setOnClickListener{
            if(checkCell(btn_6)){
                takeTurn(btn_6, 6)
            }
        }

        val btn_7 = findViewById(R.id.btn_7) as Button
        btn_7.setOnClickListener{
            if(checkCell(btn_7)){
                takeTurn(btn_7, 7)
            }
        }

        val btn_8 = findViewById(R.id.btn_8) as Button
        btn_8.setOnClickListener{
            if(checkCell(btn_8)){
                takeTurn(btn_8, 8)
            }
        }
        val btn_9 = findViewById(R.id.btn_9) as Button
        btn_9.setOnClickListener{
            if(checkCell(btn_9)){
                takeTurn(btn_9, 9)
            }
        }

        val btn_Restart = findViewById(R.id.btn_Restart) as Button
        btn_Restart.setOnClickListener({
            recreate()
        })
    }

    fun toggleButton(btn: Button, sign: String): Unit{
        btn.setText(sign)
    }


    fun takeTurn(btn: Button, position: Int ): Unit{
        if(presenter.getWinner() == 0){
            // update data on model
            val res = presenter.takeTurn(position)
            // update view
            toggleButton(btn, getTurn(res))
            // check if there is a winner in the game
            if(presenter.checkGame()){
                val winner = presenter.getWinner()
                Toast.makeText(applicationContext, "The Winner is  Player $winner ! ", Toast.LENGTH_LONG).show()
            }else{
                val nowPlaying = presenter.getTurn()
                if(!presenter.isDraw()){
                    Toast.makeText(applicationContext, "Player $nowPlaying Turn !" , Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext, "Draw !!" , Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    fun checkCell(btn: Button): Boolean{
        if(btn.text != "") return false
        return true
    }

    fun getTurn(turn: Int): String{
        if(turn == 1) return x
        else return o

    }

    fun landingPage(): Unit{
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage("Welcome to Tic Tac Srul")

        alertDialog.setPositiveButton("Play", DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i: Int ->
               Toast.makeText(applicationContext, "Good Luck !" ,Toast.LENGTH_LONG).show()
        })

        alertDialog.setNegativeButton("Exit", DialogInterface.OnClickListener(){
            dialogInterface : DialogInterface, i: Int ->

            System.exit(0)

        } )


        alertDialog.show()
    }









}
