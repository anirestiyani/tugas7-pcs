package resti.example.appmemori.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import resti.example.appmemori.data.local.AuthPref
import resti.example.appmemori.data.model.ActionState
import resti.example.appmemori.data.model.AuthUser

class AuthRepository (val context: Context){
    private val authPref: AuthPref by lazy{ AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(authPref.authUser)
    val isLoin = MutableLiveData<Boolean>(authPref.isLogin)

    suspend fun login (email: String, password: String) : ActionState<AuthUser>{
        return authPref.login(email, password)
    }

    suspend fun register (user: AuthUser) : ActionState<AuthUser>{
        return authPref.register(user)
    }

    suspend fun logout () : ActionState<Boolean>{
        return authPref.logout()
    }
}