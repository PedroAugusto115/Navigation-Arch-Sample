package com.pedropereira.navigationsample.model

import android.os.Parcel
import android.os.Parcelable

val USER_ARG = "user"
val LOGGED_USER_KEY = "LOGGED_USER"
val USER_LIST_KEY = "USER_LIST"

class User(var name: String = "",
           var age: Int = 0,
           var city: String = "",
           var email: String? = null,
           var phone: String? = null,
           var password: String = "") : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(city)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}