package com.example.apptesting.model

import android.os.Parcel
import android.os.Parcelable

data class Customers(
    var id: String,
    var name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Customers> {
        override fun createFromParcel(parcel: Parcel): Customers {
            return Customers(parcel)
        }

        override fun newArray(size: Int): Array<Customers?> {
            return arrayOfNulls(size)
        }
    }

}
