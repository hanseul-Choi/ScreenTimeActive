package com.chs.screentimeactive.repository

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.util.Log
import java.util.*

class AppUsageRepository(
    private val context: Context,
    private val appUsageDataSource: AppUsageLocalDataSource
) {
    /**
     *  @param period : 기간 (ex. Calendar.YEAR : 연, Calendar.MONTH : 월, Calendar.DATE : 일, Calendar.HOUR : 시간)
     *  @param interval : 간격 (ex. UsageStatsManager.INTERVAL_YEARLY : 연간, UsageStatsManager.INTERVAL_MONTHLY : 월간
     *                  UsageStatsManager.INTERVAL_WEEKLY : 주간, UsageStatsManager.INTERVAL_DAILY : 일간)
     *
     */
    fun getAppUsageData() : MutableList<UsageStats> {
        return appUsageDataSource.getAppUsageStats(context, Calendar.YEAR, UsageStatsManager.INTERVAL_MONTHLY)
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
}