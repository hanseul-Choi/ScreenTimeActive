package com.chs.screentimeactive.repository

import android.app.usage.UsageStats

interface AppUsageDataSource {

    fun getAppUsageStats(type: Int) : MutableList<UsageStats>
}