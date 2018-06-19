/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.addedittask

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.add_edit_task_activity.*

/**
 * Displays an add or edit task screen.
 */
class AddEditTaskActivity : AppCompatActivity() {

  private var mActionBar: ActionBar? = null

  val countingIdlingResource: IdlingResource
    @VisibleForTesting
    get() = EspressoIdlingResource.getIdlingResource()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.add_edit_task_activity)

    // Set up the toolbar.
    setSupportActionBar(toolbar)
    mActionBar = supportActionBar
    mActionBar!!.setDisplayHomeAsUpEnabled(true)
    mActionBar!!.setDisplayShowHomeEnabled(true)

    val taskId = intent.getStringExtra(ARGUMENT_EDIT_TASK_ID)

    setToolbarTitle(taskId)
    add_edit_root_view.showTaskWithId(taskId)
  }

  private fun setToolbarTitle(taskId: String?) {
    if (taskId == null) {
      mActionBar!!.setTitle(R.string.add_task)
    } else {
      mActionBar!!.setTitle(R.string.edit_task)
    }
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }

  companion object {
    const val REQUEST_ADD_TASK = 1

    const val ARGUMENT_EDIT_TASK_ID = "ARGUMENT_EDIT_TASK_ID"
  }
}
