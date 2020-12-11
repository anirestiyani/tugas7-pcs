package resti.example.appmemori.ui.auth

import android.content.Intent
import resti.example.appmemori.data.repository.AuthRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import resti.example.appmemori.R
import resti.example.appmemori.data.model.AuthUser
import resti.example.appmemori.databinding.ActivityAuthBinding
import resti.example.appmemori.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSucces(user:AuthUser?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
