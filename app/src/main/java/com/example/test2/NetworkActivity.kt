package com.example.test2


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.model.Network


class NetworkActivity : AppCompatActivity() {
    var spinner: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        spinner = findViewById(R.id.loader)
        recyclerView.adapter = NetworkAdapter(::networkClicked)

//        val snapHelper: SnapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(recyclerView)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.getOrientation())
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val presenter = ViewModelProvider(this).get(Presenter::class.java)

        presenter.loadNetworks { networks, error ->
            spinner?.visibility = View.GONE

            if (!networks.isEmpty()) {
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