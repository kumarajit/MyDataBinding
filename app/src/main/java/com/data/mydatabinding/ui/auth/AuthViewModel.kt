package com.data.mydatabinding.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.data.mydatabinding.data.repository.UserRepository

class AuthViewModel : ViewModel() {
    var email :String ? =null
    var password :String ?= null

    var authListener: AuthListener?=null
    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListener?.onFailure("Invalide email password")
            return
        }
        //success
        val loginResponse= UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)
    }
}