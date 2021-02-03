package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.model.Network
import java.lang.Exception

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)

        recyclerView.adapter = NetworkAdapter(::networkClicked)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val presenter = ViewModelProvider(this).get(Presenter::class.java)

        presenter.loadNetworks { networks, error ->
            if (networks != null) {
                (recyclerView.adapter as NetworkAdapter).updateValues(networks)
            }
        }

    }


    private fun networkClicked(network : Network){
        Log.d("Test", "Network clicked")
        ViewModelProvider(this).get(Presenter::class.java).loadStations(network.id)

    }
}