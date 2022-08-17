package com.chs.screentimeactive.repository

import android.app.usage.UsageStats
import android.content.Context

class AppUsageLocalDataSource(
    private val appUsageApi: AppUsageApi
) : AppUsageDataSource {
    override fun getAppUsageStats(context: Context, period: Int, interval: Int): MutableList<UsageStats> {
        return appUsageApi.getAppUsage(context, period, interval)
    }
}