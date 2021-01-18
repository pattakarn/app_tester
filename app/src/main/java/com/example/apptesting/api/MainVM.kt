package com.example.apptesting.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptesting.model.CustomerDetail
import com.example.apptesting.model.LoginResp
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainVM : ViewModel() {

    val url = "https://us-central1-iostesting-b3165.cloudfunctions.net/mobileApi/api/v1/"
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val postsApi = retrofit.create(MainApi::class.java)

    var responseLoginItem: MutableLiveData<LoginResp> = MutableLiveData()
    var customerDetail: MutableLiveData<CustomerDetail> = MutableLiveData()


    fun login(username: String, password: String): LiveData<LoginResp> {
        val response = postsApi.getLogin(username, password)
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
//            Log.d("response", "====== " + it.pages)
            responseLoginItem.value = it

        }
        return responseLoginItem
    }



    fun getCustomerDetail(token: String, customerId: String): LiveData<CustomerDetail> {
        val response = postsApi.getCustomerDetail(token, customerId)
        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            Log.d("customerDetail", "====== " + it.data.name)
            customerDetail.value = it

        }
        return customerDetail
    }
}