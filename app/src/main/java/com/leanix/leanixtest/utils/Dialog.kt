package com.leanix.leanixtest.utils

import android.content.Context
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.leanix.leanixtest.databinding.LayoutSortbyBinding
import android.R
import android.app.ProgressDialog
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import com.leanix.leanixtest.databinding.LayoutProgressBinding


object Dialog {


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

    fun showProgress(layout: LayoutInflater, context: Context): ProgressDialog {
        val dialog = ProgressDialog(context)
        val binding = LayoutProgressBinding.inflate(layout)
        val view = binding.root
        try {
            dialog.show()
        } catch (e: WindowManager.BadTokenException) {
        }
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
        return dialog
    }


    private lateinit var onClick: OnClick

    fun onClickSort(onClick: OnClick) {
        this.onClick = onClick
    }

    interface OnClick {
        fun setOnClick(type: Int)
    }
}