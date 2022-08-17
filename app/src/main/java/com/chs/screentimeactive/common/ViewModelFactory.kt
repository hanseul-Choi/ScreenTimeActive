package com.chs.screentimeactive.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chs.screentimeactive.repository.AppUsageApi
import com.chs.screentimeactive.repository.AppUsageLocalDataSource
import com.chs.screentimeactive.repository.AppUsageRepository
import com.chs.screentimeactive.ui.main.MainViewModel
import java.lang.IllegalArgumentException

// 추후에 Hilt로 Migration 예정
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            // MainViewModel인 경우,
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                val repository = AppUsageRepository(context, AppUsageLocalDataSource(AppUsageApi()))
                MainViewModel(repository) as T
            } else -> { // error
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}