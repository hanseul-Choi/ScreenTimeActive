package com.chs.screentimeactive.ui.main

import androidx.lifecycle.ViewModel
import com.chs.screentimeactive.repository.AppUsageRepository

class MainViewModel(
    repository: AppUsageRepository
) : ViewModel() {
    init {
        repository.showAppUsage(repository.getAppUsageData())
    }
}