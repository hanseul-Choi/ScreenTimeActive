package com.chs.screentimeactive.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chs.screentimeactive.databinding.ItemTestBinding

class MainAdapter : ListAdapter<String, MainAdapter.MainViewHolder>(MainDiffCallback()) {

    private lateinit var binding: ItemTestBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MainViewHolder(binding: ItemTestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.tvTest.text = data
        }
    }
}

class MainDiffCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}