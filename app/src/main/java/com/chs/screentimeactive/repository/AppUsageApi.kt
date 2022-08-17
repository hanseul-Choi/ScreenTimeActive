package com.chs.screentimeactive.repository

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import java.util.*

class AppUsageApi {
    fun getAppUsage(context: Context, period: Int, interval: Int): MutableList<UsageStats> {

        val cal = Calendar.getInstance()
        cal.add(period, -1) // 현재부터 1년간 데이터를 수집

        val usageStatsManager =
            context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager // 매니저 객체 가져옴

        return usageStatsManager.queryUsageStats(
            interval, cal.timeInMillis, System.currentTimeMillis() // 인터벌을 일일마다로 설정
        )
    }
}