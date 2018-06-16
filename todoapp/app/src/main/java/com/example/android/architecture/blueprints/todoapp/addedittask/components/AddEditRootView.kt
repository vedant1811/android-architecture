package com.example.android.architecture.blueprints.todoapp.addedittask.components

import android.app.Activity
import android.content.Context
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.base.getTasksRepository
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.google.common.base.Optional
import kotlinx.android.synthetic.main.add_edit_root_view.view.*
import java.util.*

class AddEditRootView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

  /**
   * `null` if this a new task, non-`null` if it's an existing task
   */
  private var mTask: Task? = null

  init {
    View.inflate(context, R.layout.add_edit_root_view, this)

    done_fab.setOnClickListener{ _ -> doneClicked() }
  }

  fun showTaskWithId(id: String) {
    context.getTasksRepository().getTask(id)
        .map(Optional<Task>::get) // will throw an error if id is incorrect
        .subscribe {
          mTask = it
          add_task_title.setText(it.title)
          add_task_description.setText(it.description)
        }
  }

  private fun doneClicked() {
    val task = Task(
        add_task_title.text.toString(),
        add_task_description.text.toString(),
        mTask?.id ?: UUID.randomUUID().toString(),
        mTask?.isCompleted ?: false
    )

    if (task.isEmpty) {
      Snackbar.make(this, R.string.empty_task_message, Snackbar.LENGTH_LONG)
          .show()
      return
    }

    context.getTasksRepository().saveTask(task)

    (context as Activity).apply {
      setResult(Activity.RESULT_OK)
      finish()
    }
  }
}
