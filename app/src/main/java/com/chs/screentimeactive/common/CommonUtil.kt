package com.chs.screentimeactive.common

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

object CommonUtil {
    fun exitApp(context: Context) {
        AlertDialog.Builder(context)
            .setCancelable(false)
            .setTitle("앱 종료")
            .setMessage("앱 사용량 확인 권한을 허용해주세요.\n(권한이 없으면 사용할 수 없습니다.)")
            .setNegativeButton("확인") { _, _ ->
                (context as AppCompatActivity).finish()
            }
            .create()
            .show()
    }


}