package com.example.filipcl_in2000_oblig1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListAdapter(val userList: ArrayList<Element>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.element, p0, false)
        return ViewHolder(v)
    }


    //this method is binding the data on the list
    override fun onBindViewHolder(p0: ViewHolder,p1: Int) {
        val element : Element = userList[p1]
        p0?.textViewTittle?.text = element.title
        p0?.textViewContent?.text = element.content
    }


    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }


    //the class is hodling the list Textview
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTittle = itemView.findViewById(R.id.elementTitle) as TextView
        val textViewContent  = itemView.findViewById(R.id.elementContent) as TextView
    }
}