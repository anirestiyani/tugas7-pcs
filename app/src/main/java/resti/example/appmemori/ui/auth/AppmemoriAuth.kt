package resti.example.appmemori.ui.auth

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import resti.example.appmemori.data.model.ActionState
import resti.example.appmemori.data.repository.AuthRepository

object AppmemoriAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>)->Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}