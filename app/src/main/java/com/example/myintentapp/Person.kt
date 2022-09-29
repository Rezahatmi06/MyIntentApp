package com.example.myintentapp

import android.os.Parcel
import android.os.Parcelable

abstract class Person(s: String, i: Int, s1: String, s2: String) {
    lateinit var age: String
    abstract val city: String
    abstract val email: String
    abstract val name: Any

    data class Person (
        val name: String?,
        val age: Int?,
        val email: String?,
        val city: String?
            ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeValue(age)
            parcel.writeString(email)
            parcel.writeString(city)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Person> {
            override fun createFromParcel(parcel: Parcel): Person {
                return Person(parcel)
            }

            override fun newArray(size: Int): Array<Person?> {
                return arrayOfNulls(size)
            }
        }
    }

}
