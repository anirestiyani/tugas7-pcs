package resti.example.appmemori.ui.auth

import androidx.lifecycle.MutableLiveData
import resti.example.appmemori.data.repository.AuthRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import resti.example.appmemori.data.model.ActionState
import resti.example.appmemori.data.model.AuthUser

class AuthViewModel(val repo: AuthRepository) : ViewModel() {
    val authUser = repo.authUser
    val isLogin = repo.isLoin
    val authLogin = MutableLiveData<ActionState<AuthUser>>()
    val authRegister = MutableLiveData<ActionState<AuthUser>>()
    val authLogout = MutableLiveData<ActionState<Boolean>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val fullName = MutableLiveData<String>()

    fun login() {
        viewModelScope.launch {
            val repo = repo.login(email.value ?: "", password.value ?: "")
            authLogin.value = repo
        }
    }

    fun register() {
        viewModelScope.launch {
            val resp = repo.register(
                    AuthUser(
                            email = email.value ?: "",
                            password = password.value ?: "",
                            fullNama = fullName.value ?: ""
                    )
            )
            authRegister.value = resp
        }
    }

    fun logout(){
        viewModelScope.launch {
            val resp = repo.logout()
            authLogout.value = resp
        }
    }
}