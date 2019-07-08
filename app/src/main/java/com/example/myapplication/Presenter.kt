package com.example.myapplication

/**
 * Class presenter so we can make this app architecture becoming MVP
 *
 * where model and view cant communicate directly
 */
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

    fun isDraw(): Boolean{
        return games.isDraw()
    }

}