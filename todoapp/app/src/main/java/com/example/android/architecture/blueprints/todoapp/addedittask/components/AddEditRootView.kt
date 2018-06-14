package com.example.android.architecture.blueprints.todoapp.addedittask.components

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.android.architecture.blueprints.todoapp.R

class AddEditRootView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
  init {
    View.inflate(context, R.layout.add_edit_root_view, this)
  }
}
