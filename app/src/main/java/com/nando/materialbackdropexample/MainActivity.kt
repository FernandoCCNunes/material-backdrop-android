package com.nando.materialbackdropexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews() {
        activity_main_backdrop.setOnBottomSheetStateChangedListener { bottomSheet, newState ->
            Log.d("Backdrop", "HERE")
        }

        activity_main_backdrop.setOnHeaderNavigationIconClickListener {
            activity_main_backdrop.toggleFrontLayer()
        }
    }
}
