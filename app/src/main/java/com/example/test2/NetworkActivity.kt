package com.example.test2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.test2.model.Network


class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)

        recyclerView.adapter = NetworkAdapter(::networkClicked)

//        val snapHelper: SnapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val presenter = ViewModelProvider(this).get(Presenter::class.java)

        presenter.loadNetworks { networks, error ->
            if (networks != null) {
                (recyclerView.adapter as NetworkAdapter).updateValues(networks)
            }
        }

    }


    private fun networkClicked(network: Network) {
        val intent = Intent(this, StationsActivity::class.java).apply {
            putExtra(StationsActivity.STATION_ID_BUNDLE, network.id)
        }
        startActivity(intent)
    }
}