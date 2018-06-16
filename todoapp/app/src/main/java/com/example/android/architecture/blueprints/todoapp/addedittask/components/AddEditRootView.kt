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
import kotlinx.android.synthetic.main.add_edit_root_view.view.*

class AddEditRootView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
  init {
    View.inflate(context, R.layout.add_edit_root_view, this)

    done_fab.setOnClickListener{ _ -> doneClicked() }
  }

  private fun doneClicked() {
    val task = Task(add_task_title.text.toString(), add_task_description.text.toString())
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
