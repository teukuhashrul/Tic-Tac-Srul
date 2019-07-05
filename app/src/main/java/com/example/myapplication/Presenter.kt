package com.example.myapplication

class Presenter {
   val games = Games()

    fun getTurn(): String{
        return games.getTurn()
    }

}