package uz.smd.marketplatform.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.core.view.isGone

/**
 * Created by Siddikov Mukhriddin on 10/2/21
 */
fun View.animateByHeight(){
    animate().translationY(height.toFloat())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                isGone = true
            }
        }).start()
}
fun View.animateByTopHeight(){
    animate().translationY(-height.toFloat())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                isGone = true
            }
        }).start()
}
fun View.animatePosition(){
    animate().translationY(0f).start()
}