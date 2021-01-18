package com.example.apptesting.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LoginResp (
    @SerializedName("status") val status: Int,
    @SerializedName("token") val token: String,
    @SerializedName("customers") val customers: ArrayList<Customers>
                     ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        arrayListOf<Customers>().apply {
            parcel.readList(this, Customers::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(status)
        parcel.writeString(token)
        arrayListOf<Customers>().apply {
            parcel.writeList(customers)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginResp> {
        override fun createFromParcel(parcel: Parcel): LoginResp {
            return LoginResp(parcel)
        }

        override fun newArray(size: Int): Array<LoginResp?> {
            return arrayOfNulls(size)
        }
    }

}

