package com.example.tony.testshell.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tony.testshell.Models.TestModel
import com.example.tony.testshell.R

/**
 * Created by Tony on 11/1/2017.
 */
class RecyclerAdapter(var listOfText:ArrayList<TestModel>,
                      val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return listOfText.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindView(listOfText[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.recycler_row, parent,false)
        return ViewHolder(view)
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var showText = itemView.findViewById<TextView>(R.id.listTextViewID)

        fun bindView(testModel: TestModel){
            showText.text = testModel.sampleText.toString()
        }

    }
}