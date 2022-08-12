package com.chs.screentimeactive.common

import android.content.Context
import android.util.AttributeSet
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.chs.screentimeactive.R
import com.google.android.material.appbar.MaterialToolbar

class LottieGrassToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialToolbar(context, attrs, defStyleAttr) {
    lateinit var lottieDrawable: LottieDrawable

    init {
        setBackgroundLottie()
    }

    private fun setBackgroundLottie() {
        lottieDrawable = LottieDrawable()

        LottieCompositionFactory.fromRawRes(context, R.raw.green_grass).addListener {
            lottieDrawable.composition = it
            lottieDrawable.repeatCount = LottieDrawable.INFINITE
            lottieDrawable.playAnimation()
            super.setBackground(lottieDrawable)
        }
    }
}