package com.devvinay.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.devvinay.runningtrackerapp.repositories.MainRepository
import javax.inject.Inject

class StatisticsViewModel @ViewModelInject constructor(val mainRepository: MainRepository):ViewModel() {
}