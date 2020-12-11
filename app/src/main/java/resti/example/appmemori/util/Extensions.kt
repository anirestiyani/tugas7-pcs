package resti.example.appmemori.util


import android.content.SharedPreferences
import com.google.gson.Gson
import resti.example.appmemori.data.model.AuthUser

inline fun <reified T> SharedPreferences.getObject(key: String, defValue: T? = null): T? {
    val json = getString(key, null)
    return Gson().fromJson(json, T::class.java) ?: defValue
}

fun SharedPreferences.Editor.putObject(key: String, value: Any?): SharedPreferences.Editor {
    val json = Gson().toJson(value)
    putString(key, json)
    return this
}