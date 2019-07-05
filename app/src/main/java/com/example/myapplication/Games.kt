package com.example.myapplication

class Games {
    // first row
    var a = 0
    var b = 0
    var c = 0
    // second row
    var d = 0
    var e = 0
    var f = 0
    // third row
    var g = 0
    var h = 0
    var i = 0

    var winner = 0

    var turn = 1

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
        }else {
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
            if(a == b || b == c ) winner = a
            else if(d == e || e == f ) winner = d
            else if (g == h || h == i) winner = g
        }
    }

    fun checkVertical(): Unit{
        if(winner == 0){
            if(a == d || d == g ) winner = a
            else if(b == e || e == h ) winner = b
            else if(c == f || f == i ) winner = c
        }
    }

    fun checkDiagonal(): Unit {
        if(winner == 0){
            if(a == e && e == i || g == e && e == c){
                winner = e
            }
        }
    }

    fun checkAll(): String{
        checkDiagonal()
        checkHorizontal()
        checkVertical()
        return "the winner is $winner"
    }

    fun printBoard(): String{
        return "\n $a  $b  $c \n $d    $e  $f \n   $g  $h  $i"
    }

    fun getTurn(): String{
        if(turn == 1){
            val res = turn
            turn++
            return "Player 1"
        }else{
            val res = turn
            turn--
            return "Player 2"
        }
    }

    fun takeTurn(position: Int){

    }
}