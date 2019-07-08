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

/**
 * class main activity for the ui
 */
class MainActivity : AppCompatActivity() {
    // X is for player 1
   private val x = "X"
    // O is for player 2
   private val o = "O"

    // instantiate presenter class
    val presenter = Presenter()

    // oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButton()

        val model = Games()

        // give landing page
        landingPage()



    }

    /**
     * function to set all the button necessary for the ui
     * 1 get the id
     * 2. set on clickk listener
     * 3. do something when click (call the presenter to get the model )
     *
     */
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

    /**
     * function to change the state of the button
     *  from "" -> X or "" -> O
     */
   private fun toggleButton(btn: Button, sign: String): Unit{
        btn.setText(sign)
    }

    /**
     * function to take turns for the ui
     * 1. update data in the model
     * 2. update view
     * 3. check game states
     */
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

    /**
     * function to check if the cell already filled
     */
    fun checkCell(btn: Button): Boolean{
        if(btn.text != "") return false
        return true
    }

    /**
     * function to format from numbers of player identifier become their sign
     *  1 - > x
     *  2 - > o
     */
    fun getTurn(turn: Int): String{
        if(turn == 1) return x
        else return o

    }

    /**
     * function for landing page for the ui
     */
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
