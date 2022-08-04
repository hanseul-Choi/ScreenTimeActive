package com.chs.screentimeactive.ui.main

import android.os.Bundle
import android.view.View
import com.chs.screentimeactive.R
import com.chs.screentimeactive.base.BaseFragment
import com.chs.screentimeactive.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MainAdapter()
        adapter.submitList(listOf("test1","test2","test3","test4","test5","test6","test7","test8"))

        binding.rvTest.adapter = adapter
    }
}