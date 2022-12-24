package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod

object Utils {
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?):String{
        return value?.toString() ?:""
    }
    @JvmStatic
    fun stringToDouble(value:String):Double?{

        if(value.isEmpty()){
            return null
        }else{
            return value.toDouble()
        }

    }

}