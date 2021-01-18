package com.example.apptesting.api

import com.example.apptesting.model.CustomerDetail
import com.example.apptesting.model.LoginResp
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MainApi {

    @FormUrlEncoded
    @POST("login")
    fun getLogin(@Field("username") username: String, @Field("password") password: String): Observable<LoginResp>


    @FormUrlEncoded
    @POST("getCustomerDetail")
    fun getCustomerDetail(@Field("token") token: String, @Field("customerId") customerId: String): Observable<CustomerDetail>

}