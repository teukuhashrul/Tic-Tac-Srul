package com.example.myapplication

class Presenter {
   private val games = Games()

    fun getTurn(): Int{
        return games.getTurn()
    }

    fun takeTurn(position: Int): Int{
        val res = games.takeTurn(position)
        return res
    }

    fun checkGame(): Boolean{
        return games.checkWinner()
    }

    fun getWinner(): Int{
        return games.getWinner()
    }

}