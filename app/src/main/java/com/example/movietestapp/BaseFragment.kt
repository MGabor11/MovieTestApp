package com.example.movietestapp

import android.content.Context
import com.example.movietestapp.ui.FragmentCommunicator
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    protected lateinit var mFragmentCommunicator: FragmentCommunicator

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mFragmentCommunicator = context as FragmentCommunicator

        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement all interface")
        }

    }

}
