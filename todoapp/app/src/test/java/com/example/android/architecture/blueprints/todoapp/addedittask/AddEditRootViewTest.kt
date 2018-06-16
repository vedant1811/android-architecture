package com.example.android.architecture.blueprints.todoapp.addedittask

import android.app.Activity
import android.widget.TextView
import com.example.android.architecture.blueprints.todoapp.addedittask.components.AddEditRootView
import com.example.android.architecture.blueprints.todoapp.base.getTasksRepository
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.utils.findSnackbarTextView
import com.example.android.architecture.blueprints.todoapp.utils.getTasksInRepo
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
  private lateinit var activity: Activity

  @Before
  fun setup() {
    activity = Robolectric.setupActivity(Activity::class.java)
    mAddEditRootView = AddEditRootView(activity)
  }

  @Test
  fun `empty title and description should show error`() {
    // when
    mAddEditRootView.done_fab.performClick()

    // then
    val textView: TextView? = mAddEditRootView.findSnackbarTextView()
    assertThat(textView, `is`(notNullValue()))
  }

  @Test
  fun `empty description should save`() {
    // when
    mAddEditRootView.add_task_title.setText("Title")
    mAddEditRootView.done_fab.performClick()

    // then
    assertSave()
  }

  @Test
  fun `should save new task to repo and finish activity`() {
    // when
    mAddEditRootView.add_task_title.setText("Title")
    mAddEditRootView.add_task_description.setText("Description")
    mAddEditRootView.done_fab.performClick()

    // then
    assertSave()
  }

  @Test
  fun `should display existing task`() {
    // given
    val task = createTask()

    // when
    mAddEditRootView.showTaskWithId(task.id)

    // then
    assertThat(mAddEditRootView.add_task_title.text.toString(), equalTo(task.title))
    assertThat(mAddEditRootView.add_task_description.text.toString(), equalTo(task.description))
  }

  private fun createTask(): Task {
    val task = Task("title", "description")
    activity.getTasksRepository().saveTask(task)

    return task
  }

  private fun assertSave() {
    val textView: TextView? = mAddEditRootView.findSnackbarTextView()
    assertThat(textView, `is`(nullValue()))

    assertThat(getTasksInRepo().count(), `is`(1))

    assertThat(activity.isFinishing, `is`(true))
  }
}
