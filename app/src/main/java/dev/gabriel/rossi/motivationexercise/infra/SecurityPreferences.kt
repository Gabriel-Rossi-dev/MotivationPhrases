package dev.gabriel.rossi.motivationexercise.infra

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.SharedFlow

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun storeString(key: String, str: String){
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String{
        return security.getString(key, "") ?: ""
    }

    fun clearCache(){
        security.edit().clear().apply()
    }
}