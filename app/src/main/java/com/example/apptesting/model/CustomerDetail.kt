package com.example.apptesting.model

import com.google.gson.annotations.SerializedName

data class CustomerDetail(
    @SerializedName("data") val data: Detail,
    @SerializedName("status") var status: Int
)

data class Detail(
    var customerGrade: String,
    var id: String,
    var isCustomerPremium: Boolean,
    var name: String,
    var sex: String
)
