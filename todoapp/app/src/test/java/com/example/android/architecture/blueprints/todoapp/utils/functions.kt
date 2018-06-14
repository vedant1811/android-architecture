package com.example.android.architecture.blueprints.todoapp.utils

import android.support.design.internal.SnackbarContentLayout
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * @return a TextView if a snackbar is shown anywhere in the view hierarchy.
 *
 * NOTE: calling Snackbar.make() does not create a snackbar. Only calling #show() will create it.
 *
 * If the textView is not-null you can check its text.
 */
fun View.findSnackbarTextView(): TextView? {
  val possibleSnackbarContentLayout = findSnackbarLayout()?.getChildAt(0) as? SnackbarContentLayout
  return possibleSnackbarContentLayout
      ?.getChildAt(0) as? TextView
}

private fun View.findSnackbarLayout(): Snackbar.SnackbarLayout? {
  when (this) {
    is Snackbar.SnackbarLayout -> return this
    !is ViewGroup -> return null
  }
  // otherwise traverse the children

  // the compiler needs an explicit assert that `this` is an instance of ViewGroup
  this as ViewGroup

  (0 until childCount).forEach { i ->
    val possibleSnackbarLayout = getChildAt(i).findSnackbarLayout()
    if (possibleSnackbarLayout != null) return possibleSnackbarLayout
  }
  return null
}
