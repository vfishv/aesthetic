/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
 */
package com.afollestad.aesthetic.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.afollestad.aesthetic.Aesthetic.Companion.get
import com.afollestad.aesthetic.utils.distinctToMainThread
import com.afollestad.aesthetic.utils.subscribeTo
import io.reactivex.disposables.Disposable

/** @author Aidan Follestad (afollestad) */
@SuppressLint("PrivateResource")
class AestheticSwipeRefreshLayout(
  context: Context,
  attrs: AttributeSet? = null
) : SwipeRefreshLayout(context, attrs) {

  private var colorSubscription: Disposable? = null

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()

    colorSubscription = get().swipeRefreshLayoutColors()
        .distinctToMainThread()
        .subscribeTo(::setColorSchemeColors)
  }

  override fun onDetachedFromWindow() {
    colorSubscription?.dispose()
    super.onDetachedFromWindow()
  }
}
