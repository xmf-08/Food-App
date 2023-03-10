package com.example.foodapp

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreferance {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var catchList:ArrayList<User>
        get() = gsonStringToArrayList(preferences.getString("keyList","[]")!!)
        set(value) = preferences.edit{
            if (value!=null){
                it.putString("keyList", arrayListToGsonString(value))
            }
        }

    fun arrayListToGsonString(list:ArrayList<User>):String{
        val gson = Gson()
        return gson.toJson(list)
    }
    fun gsonStringToArrayList(str:String):ArrayList<User>{
        val gson = Gson()
        val type = object: TypeToken<ArrayList<User>>(){}.type
        return gson.fromJson(str, type)
    }
}