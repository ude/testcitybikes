package com.example.test2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test2.model.NetworkList
import com.example.test2.repository.CustomExecutor
import com.example.test2.repository.remote.Injection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Injection.getApi().getNetworks().enqueue(object: Callback<NetworkList>{
            override fun onFailure(call: Call<NetworkList>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<NetworkList>, response: Response<NetworkList>) {
                TODO("Not yet implemented")
            }

        })
        Thread(
            Runnable {
                val result = Injection.getApi().getNetworks().execute()
                Log.d("TEST", result.body().toString()?:"Error")

            }
        ).start()

    }
}