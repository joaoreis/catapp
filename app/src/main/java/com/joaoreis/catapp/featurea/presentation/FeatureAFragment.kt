package com.joaoreis.catapp.featurea.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.joaoreis.catapp.R
import com.joaoreis.catapp.databinding.FragmentFeatureABinding
import org.koin.android.viewmodel.ext.android.viewModel

class FeatureAFragment : Fragment(R.layout.fragment_feature_a) {

    private lateinit var binding: FragmentFeatureABinding
    private val viewModel by viewModel<FeatureAViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeatureABinding.bind(view)
        setupViews()
    }

    private fun setupViews() {
        binding.button.setOnClickListener {
            navigateToFeatureB()
        }
    }

    private fun navigateToFeatureB() {
        val toFeatureB = FeatureAFragmentDirections.actionFeatureAToFeatureB()
        findNavController().navigate(toFeatureB)
    }

}
