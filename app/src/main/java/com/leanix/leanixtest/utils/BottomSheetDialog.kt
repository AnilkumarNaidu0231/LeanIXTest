package com.leanix.leanixtest.utils

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.leanix.leanixtest.databinding.LayoutSortbyBinding

object BottomSheetDialog {


    fun createBottomSheet(layout: LayoutInflater, context: Context) {
        val dialog = BottomSheetDialog(context)
        val binding = LayoutSortbyBinding.inflate(layout)
        val view = binding.root

        binding.sortbyName.setOnClickListener {
            onClick.setOnClick(1)
            dialog.dismiss()
        }

        binding.sortbyDate.setOnClickListener {

            onClick.setOnClick(2)
            dialog.dismiss()
        }

        binding.sortbyDefault.setOnClickListener {
            onClick.setOnClick(0)
            dialog.dismiss()
        }
        dialog.setCancelable(true)
        dialog.setContentView(view)

        dialog.show()
    }


   private lateinit var onClick: OnClick

    fun onClickSort(onClick: OnClick) {
        this.onClick = onClick
    }

    interface OnClick {
        fun setOnClick(type: Int)
    }
}