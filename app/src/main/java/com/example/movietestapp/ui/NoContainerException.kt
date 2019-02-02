package com.example.movietestapp.ui

class NoContainerException : Exception() {

    override val message: String?
        get() = "There is no container for the Fragment!"

}
