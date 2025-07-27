package com.shenawynkov.bm_days

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class RedFragment:Fragment(R.layout.fragment_red)
{

    val list = arrayListOf("red","green","yellow","black","orange")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv= view.findViewById<RecyclerView>(R.id.rv_list)
        rv.apply {
            adapter= RecyclerAdapter(list)
            layoutManager= LinearLayoutManager(this@RedFragment.context)
        }
    }
}