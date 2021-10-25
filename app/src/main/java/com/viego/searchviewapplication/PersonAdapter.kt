package com.viego.searchviewapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.viego.searchviewapplication.databinding.RowItemBinding
import com.viego.searchviewapplication.databinding.RowTagBinding

class PersonAdapter(
    var list: ArrayList<Person>
) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(
        val rowItemBinding: RowItemBinding ): RecyclerView.ViewHolder(rowItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder  =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_item,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowItemBinding.person = list[position]
    }

    override fun getItemCount(): Int = list.size

}