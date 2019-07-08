package com.example.myapplication

import android.util.Log

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

    private var winner = 0

    private var turn = 1

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

    fun checkDiagonal(): Unit {
        if(winner == 0){
            if( (a == e && e == i) || (g == e && e == c) ){
                winner = e
            }
        }

        Log.d("winner", "the winner is $winner")

    }

    fun checkAll(): Unit{
        checkDiagonal()
        checkHorizontal()
        checkVertical()
    }

    fun getWinner(): Int{
        return winner
    }

    fun checkWinner(): Boolean{
        if(winner != 0) return true
        return false
    }

    fun printBoard(): String{
        return "\n $a  $b  $c \n $d    $e  $f \n   $g  $h  $i"
    }

   fun getTurn(): Int{
       return turn
   }

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
        return res
    }
}