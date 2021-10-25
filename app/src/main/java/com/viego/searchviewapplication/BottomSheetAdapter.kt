package com.viego.searchviewapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.viego.searchviewapplication.databinding.RowTagBinding

class BottomSheetAdapter (var list: ArrayList<Person>
) : RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    inner class ViewHolder(
        val rowItemBinding: RowTagBinding
    ): RecyclerView.ViewHolder(rowItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetAdapter.ViewHolder  =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_tag,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowItemBinding.person = list[position]
    }

    override fun getItemCount(): Int = list.size

}