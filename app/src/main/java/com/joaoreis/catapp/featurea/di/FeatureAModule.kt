package com.joaoreis.catapp.featurea.di

import com.joaoreis.catapp.featurea.presentation.FeatureAViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureAModule = module {
    viewModel {
        FeatureAViewModel()
    }
}
