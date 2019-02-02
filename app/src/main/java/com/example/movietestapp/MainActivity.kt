package com.example.movietestapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.movietestapp.databinding.ActivityMainBinding
import com.example.movietestapp.ui.ViewModelFactory
import com.example.movietestapp.ui.main.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ActivitySharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        setSupportActionBar(toolbar)

        loadDefaultFragment()
    }

    private fun loadDefaultFragment() {
        loadFragment(MainFragment.newInstance(), BaseActivity.FragmentLoadType.ADD)
    }

    override val containerId: Int
        get() = R.id.container
}
