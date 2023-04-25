package com.alessandrofarandagancio.geckowrapper.ui.fitness.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alessandrofarandagancio.geckowrapper.R
import com.alessandrofarandagancio.geckowrapper.model.UICoin

class CoinItemAdapter(private val onClick: (UICoin) -> Unit) :
    ListAdapter<UICoin, CoinItemAdapter.CoinViewHolder>(CoinDiffCallback) {

    class CoinViewHolder(view: View, val onClick: (UICoin) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.findViewById(R.id.name)
        private val textViewAddress: TextView = view.findViewById(R.id.address)
        private lateinit var currentCoin: UICoin

        init {
            view.setOnClickListener {
                onClick(currentCoin)
            }
        }

        fun bind(coin: UICoin) {
            currentCoin = coin
            textViewName.text = coin.name
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coin_item, viewGroup, false)

        return CoinViewHolder(view, onClick)
    }

    override fun onBindViewHolder(viewHolder: CoinViewHolder, position: Int) {
        val school = getItem(position)
        viewHolder.bind(school)
    }
}

object CoinDiffCallback : DiffUtil.ItemCallback<UICoin>() {
    override fun areItemsTheSame(oldItem: UICoin, newItem: UICoin): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UICoin, newItem: UICoin): Boolean {
        return oldItem.id == newItem.id
    }
}
