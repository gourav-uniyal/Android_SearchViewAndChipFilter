package com.viego.searchviewapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.viego.searchviewapplication.databinding.LayoutBottomSheetBinding

class DialogSheetBottomFragment() : BottomSheetDialogFragment() {

    private lateinit var binding: LayoutBottomSheetBinding

    private var people: ArrayList<Person> = arrayListOf()
    private var bottomSheetAdapter = BottomSheetAdapter(people)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = LayoutBottomSheetBinding.inflate(inflater, container, false)

        initRecycleView()
        return binding.root
    }

    fun initRecycleView(){
        people = arrayListOf(
            Person("Eric G", 19),
            Person("Reen", 19),
            Person("Jeff", 21),
            Person("Geoffrey", 19),
            Person("Lorem ipsum", 35),
            Person("Paul N", 23),
            Person("Pushpa T", 25),
            Person("Diana", 20),
            Person("Peter", 24),
            Person("Amos", 41),
            Person("Steve", 17),
        )

        val flexBoxLayoutManager : FlexboxLayoutManager = FlexboxLayoutManager(context)
        flexBoxLayoutManager.flexDirection = FlexDirection.ROW
        flexBoxLayoutManager.justifyContent = JustifyContent.SPACE_AROUND

        binding.rvTags.layoutManager = flexBoxLayoutManager

        bottomSheetAdapter = BottomSheetAdapter(people).also {

            binding.rvTags.adapter = it
            binding.rvTags.adapter!!.notifyDataSetChanged()
        }
    }

    companion object {
        const val TAG = "BottomSheetFragment"
    }
}