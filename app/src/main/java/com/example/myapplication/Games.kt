package com.example.myapplication

import android.util.Log

/**
 *  This class is for the model
 *
 *  the 3 X 3 board is modeled with nine variables
 *
 *  a b c
 *  d e f
 *  g h i
 *
 *  There are 3 type of value in 1 cell
 *  0 : not filled
 *  1 : player 1
 *  2 : player 2
 *
 *
 */
class Games {
    // first row
    private var a = 0
    private var b = 0
    private var c = 0
    // second row
    private var d = 0
    private var e = 0
    private  var f = 0
    // third row
    private var g = 0
    private var h = 0
    private var i = 0

    // 1 if the player 1 is the winner , 2 if the player 2 is the winner , 0 there are no winner yet
    private var winner = 0

    // to know whose turn. 1 is for player 1 , 2 is for player 2
    private var turn = 1

    // to know how many boxes already filled, if there are 9 filled boxes it means the game end with a draw
    private var filledBoxes = 0

    /**
     * function  to do player turn
     *
     *  param : position
     *  1 for a
     *  2 for b
     *  3 for c
     *  4 for d
     *  5 for e
     *  6 for f
     *  7 for g
     *  8 for h
     *  9 for i
     */
    fun player_Turn(position: Int): Unit{
        if(position == 1){
            a = 1
        }else if(position == 2){
            b = 1
        }else if(position == 3){
            c = 1
        }else if(position == 4){
            d = 1
        }else if(position == 5){
            e = 1
        }else if(position == 6){
            f = 1
        }else if(position == 7){
            g = 1
        }else if(position == 8){
            h = 1
        }else if(position == 9) {
            i = 1
        }


    }

    fun enemy_Turn(position: Int): Unit{
        if(position == 1){
            a = 2
        }else if(position == 2){
            b = 2
        }else if(position == 3){
            c = 2
        }else if(position == 4){
            d = 2
        }else if(position == 5){
            e = 2
        }else if(position == 6){
            f = 2
        }else if(position == 7){
            g = 2
        }else if(position == 8){
            h = 2
        }else {
            i = 2
        }
    }

    /**
     * function to check the horizontal line
     * there is a winner if there is a line
     *  - - -
     */
    fun checkHorizontal(): Unit{
        if(winner == 0){
            if(a == b && b == c ) {
                winner = a
            }
            else if(d == e && e == f ){
                winner = d
            }
            else if (g == h && h == i){
                winner = g
            }
        }

        Log.d("winner", "the winner is $winner")
    }

    /**
     * function to check vertical line
     *
     *   -
     *   -
     *   -
     */
    fun checkVertical(): Unit{
        if(winner == 0){
            if(a == d && d == g ){
                winner = a
            }
            else if(b == e && e == h ){
                winner = b
            }
            else if(c == f && f == i ){
                winner = c
            }
        }

        Log.d("winner", "the winner is $winner")

    }


    /**
     * function to check diagonal line
     *
     * -                    -
     *   -      OR      -
     *     -        -
     */
    fun checkDiagonal(): Unit {
        if(winner == 0){
            if( (a == e && e == i) || (g == e && e == c) ){
                winner = e
            }
        }

        Log.d("winner", "the winner is $winner")

    }

    /**
     * wrapper method to call all lines
     */
    fun checkAll(): Unit{
        checkDiagonal()
        checkHorizontal()
        checkVertical()
    }

    /**
     * to get who is the winner
     *  0 : no winner yet
     *  1 : player 1 is the winner
     *  2 : player 2 is the winner
     */
    fun getWinner(): Int{
        return winner
    }

    /**
     *  function to know if there is already a winner
     */
    fun checkWinner(): Boolean{
        if(winner != 0) return true
        return false
    }

    /**
     * function to check the board in the model
     * printed in terminal
     */
    fun printBoard(): String{
        return "\n $a  $b  $c \n $d    $e  $f \n   $g  $h  $i"
    }

    /**
     * function to know whose turn it is
     */
   fun getTurn(): Int{
       return turn
   }

    /**
     * function to do 1 turn
     */
    fun takeTurn(position: Int): Int{
        val res = turn
        if(turn == 1){
            // toggle turn into the opposite
            turn = 2
            // call player turn
            player_Turn(position)

        }else{
            // toggle turn into the opposite
            turn = 1
            // call enemy turn
            enemy_Turn(position)
        }
        // return whose turn it is
        checkAll()
        // increment the checkedBoxes
        filledBoxes++
        return res
    }

    /**
     * function to check if the game already ended in a draw
     */
    fun isDraw(): Boolean{
        if(filledBoxes == 9) return true
        return false
    }

}