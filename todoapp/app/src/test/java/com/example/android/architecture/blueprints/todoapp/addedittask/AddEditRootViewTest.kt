package com.example.android.architecture.blueprints.todoapp.addedittask

import android.app.Activity
import android.widget.TextView
import com.example.android.architecture.blueprints.todoapp.addedittask.components.AddEditRootView
import com.example.android.architecture.blueprints.todoapp.utils.findSnackbarTextView
import kotlinx.android.synthetic.main.add_edit_root_view.view.*

import org.hamcrest.Matchers.*
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AddEditRootViewTest {

  private lateinit var mAddEditRootView: AddEditRootView

  @Before
  fun setup() {
    val activity = Robolectric.setupActivity(Activity::class.java)
    mAddEditRootView = AddEditRootView(activity)
  }

  @Test
  fun `empty title should show error`() {
    // when
    mAddEditRootView.done_fab.performClick()

    // then
    val textView: TextView? = mAddEditRootView.findSnackbarTextView()
    assertThat(textView, `is`(notNullValue()))
  }
}
