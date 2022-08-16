package com.chs.screentimeactive.repository

import android.app.usage.UsageStats

class AppUsageLocalDataSource(
    private val appUsageApi: AppUsageApi
) : AppUsageDataSource {
    override fun getAppUsageStats(type: Int): MutableList<UsageStats> {
        return appUsageApi.getAppUsage()
    }
}