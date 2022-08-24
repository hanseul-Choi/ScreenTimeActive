package com.chs.screentimeactive.ui.main

import android.app.usage.UsageStats
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chs.screentimeactive.repository.AppUsageRepository
import java.util.*

class MainViewModel(
    private val repository: AppUsageRepository
) : ViewModel() {
    private val _appUsageData = MutableLiveData<List<UsageStats>>()
    val appUsageData: LiveData<List<UsageStats>> = _appUsageData

    init {
        getAppUsageData()
    }

    fun getAppUsageData() {
        _appUsageData.value = repository.getAppUsageData()
    }

    fun showAppUsage(usageStats: MutableList<UsageStats>) {
        // 최근 사용으로 sorting
        usageStats.sortWith { right, left ->
            compareValues(left.lastTimeUsed, right.lastTimeUsed)
        }

        usageStats.forEach{ it ->
            Log.d("usage", "packageName : ${it.packageName}, last time used ${Date(it.lastTimeUsed)}, " +
                    "total foreground time: ${it.totalTimeInForeground}")
        }
    }

    // 테마별 사용량으로 필터링

}