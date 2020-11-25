package com.example.androidtv

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat

/**
 * This class demonstrates how to extend [androidx.leanback.app.ErrorFragment].
 */
class ErrorFragment : androidx.leanback.app.ErrorFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.app_name)
    }

    internal fun setErrorContent() {
        imageDrawable = ResourcesCompat.getDrawable(resources, R.drawable.lb_ic_sad_cloud, null)
        message = resources.getString(R.string.error_fragment_message)
        setDefaultBackground(TRANSLUCENT)

        buttonText = resources.getString(R.string.dismiss_error)
        buttonClickListener = View.OnClickListener {
            fragmentManager?.beginTransaction()?.remove(this@ErrorFragment)?.commit()
        }
    }

    companion object {
        private const val TRANSLUCENT = true
    }
}