package com.mypractice.codingtestvirtusastrings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val optionOne = MutableLiveData<String>()
    private val optionTwo = MutableLiveData<String>()

    val optionOneLive: LiveData<String>
        get() = optionOne

    val optionTwoLive: LiveData<String>
        get() = optionTwo

    enum class Options{
        OPTION_ONE, OPTION_TWO
    }

    fun processStrings(firstStr: String, secondStr: String){
        fetchDifferences(firstStr.toUpperCase(), secondStr.toUpperCase(), Options.OPTION_ONE)
        fetchDifferences(secondStr.toUpperCase(), firstStr.toUpperCase(), Options.OPTION_TWO)
    }

    private fun fetchDifferences(firstStr: String, secondStr: String, option: Options){
        var leftOut = firstStr.toCharArray().filter {
            !secondStr.contains(it)
        }
        when(option){
            Options.OPTION_ONE -> optionOne.value = leftOut?.distinct().joinToString ( "" )
            Options.OPTION_TWO -> optionTwo.value = leftOut?.distinct().joinToString ( "" )
        }

        //Log.d("leftOutChars", logRef+": "+leftOut1?.distinct().toString())
    }
}