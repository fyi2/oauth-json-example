package com.example.tony.testshell.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tony.testshell.Adapters.RecyclerAdapter
import com.example.tony.testshell.Data.DataService

import com.example.tony.testshell.R
import com.example.tony.testshell.Models.TestModel
import kotlinx.android.synthetic.main.fragment_test_two.*


/**
 * A simple [Fragment] subclass.
 */
class TestTwoFragment : Fragment() {
    var recyclerAdapter: RecyclerAdapter? = null
    var textList:ArrayList<TestModel>? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_test_two, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        testTwoFragmentRecyclerID.setHasFixedSize(true)
        recyclerAdapter = RecyclerAdapter(DataService.testModel,context)

        testTwoFragmentRecyclerID.layoutManager = linearLayoutManager
        testTwoFragmentRecyclerID.adapter = recyclerAdapter


    }

}// Required empty public constructor
