package com.example.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.model.Network

class NetworkAdapter(val networkSelected: (Network) -> Unit) : RecyclerView.Adapter<NetworkAdapter.ViewHolder>() {

    private val items: ArrayList<Network> = ArrayList()

    fun updateValues(stations: List<Network>) {
        items.apply {
            clear()
            addAll(stations)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.network_item, null)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view){
            networkSelected.invoke(items[it])
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View, clickListener: ((Int) -> Unit)) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.networkTitle)
        private val subnameTextView = itemView.findViewById<TextView>(R.id.networkSubTitle)

        init {
            itemView.setOnClickListener {
                clickListener.invoke(adapterPosition)
            }
        }

        fun bind(item: Network) {
            nameTextView.text = item.name
            subnameTextView.text = item.location.city
        }
    }
}
