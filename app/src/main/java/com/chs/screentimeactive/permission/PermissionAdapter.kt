package com.chs.screentimeactive.permission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chs.screentimeactive.databinding.ItemRequirePermissionBinding

// 나중에 확장성을 위해서는 Permission model을 만들어서 따로 RecyclerView Data에 심어주면 될듯 (지금은 권한이 하나라서..)
class PermissionAdapter : RecyclerView.Adapter<PermissionAdapter.PermissionViewHolder>() {

    // check permission size
    var size: Int = 1

    // binding
    private lateinit var binding: ItemRequirePermissionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionViewHolder {
        binding = ItemRequirePermissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PermissionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PermissionViewHolder, position: Int) {
        // viewholder 작업
    }

    override fun getItemCount(): Int {
        return size
    }

    inner class PermissionViewHolder(binding: ItemRequirePermissionBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}