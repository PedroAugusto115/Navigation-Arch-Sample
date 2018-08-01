package com.pedropereira.navigationsample.model

val LOGGED_USER_KEY = "LOGGED_USER"
val USER_LIST_KEY = "USER_LIST"

class User(val name: String,
           val age: Int,
           val city: String,
           val email: String?,
           val phone: String?,
           val password: String)