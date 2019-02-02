package com.example.movietestapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movietestapp.BaseFragment
import com.example.movietestapp.ActivitySharedViewModel
import com.example.movietestapp.R
import com.example.movietestapp.ui.ViewModelFactory
import com.example.movietestapp.ui.main.adapter.MovieListAdapter
import com.example.movietestapp.util.hideKeyboard
import javax.inject.Inject

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private val activityViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it, viewModelFactory).get(ActivitySharedViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: com.example.movietestapp.databinding.FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container, false
        )
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        binding.listAdapter = MovieListAdapter()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.progressCallback = { isLoading, errorMessage ->
            if (isLoading) {
                hideKeyboard(activity)
            }
            activityViewModel?.isLoading?.value = isLoading
            errorMessage?.let {
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.responseLiveData.observe(this, Observer {
            viewModel.isEmptyLiveData.value = it.isEmpty()
        })
    }

    override fun onDestroyView() {
        viewModel.progressCallback = null
        super.onDestroyView()
    }


}