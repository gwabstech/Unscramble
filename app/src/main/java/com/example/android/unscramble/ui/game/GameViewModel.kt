package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){

    public var score = 0
    private var _currentWordCount = 0
    private lateinit var _currentScrambledWord: String
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String


    val currentScrambledWord: String
        get() = _currentScrambledWord


    init {
        getNextWord()
        Log.d("GameFragment", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean{
        return if (_currentWordCount< MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else false
    }


    private var _score = 0
    val scoree: Int
        get() = _score

}