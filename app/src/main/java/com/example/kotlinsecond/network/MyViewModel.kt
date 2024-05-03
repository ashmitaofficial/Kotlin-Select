package com.example.kotlinsecond.network

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinsecond.model.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MyViewModel(private val application:Application):AndroidViewModel(application) {

    init {
        getData()
    }

    private lateinit var retrofit: Retrofit
    public val myLiveData= MutableLiveData<ArrayList<Todo>>()


    public fun getData()
    {
        retrofit= MyRetrofitBuilder.build()
        retrofit.create(ApiInterface::class.java).getTodos().enqueue(object :Callback<ArrayList<Todo>>{
            override fun onResponse(call: Call<ArrayList<Todo>>, response: Response<ArrayList<Todo>>) {
                 val list=response.body()
                myLiveData.postValue(list)
            }

            override fun onFailure(call: Call<ArrayList<Todo>>, t: Throwable) {
                Toast.makeText(application,t.message,Toast.LENGTH_LONG)
            }


        })


    }

}