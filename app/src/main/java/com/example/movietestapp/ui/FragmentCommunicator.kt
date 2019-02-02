package com.example.movietestapp.ui

import dagger.android.support.DaggerFragment

interface FragmentCommunicator {
    @Throws(NoContainerException::class)
    fun onNewFragmentSelected(fragment: DaggerFragment, replaceIt: Boolean, needToBackStack: Boolean)
}
