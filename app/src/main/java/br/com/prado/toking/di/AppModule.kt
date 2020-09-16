package br.com.prado.toking.di

import br.com.prado.toking.viewModel.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainActivityViewModel() }
}
