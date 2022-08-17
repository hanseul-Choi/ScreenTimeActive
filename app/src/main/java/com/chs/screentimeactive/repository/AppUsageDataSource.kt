package com.chs.screentimeactive.repository

import android.app.usage.UsageStats
import android.content.Context

interface AppUsageDataSource {

    fun getAppUsageStats(context: Context, period: Int, interval: Int) : MutableList<UsageStats>
}