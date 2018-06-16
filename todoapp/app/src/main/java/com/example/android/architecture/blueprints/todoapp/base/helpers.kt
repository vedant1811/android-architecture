package com.example.android.architecture.blueprints.todoapp.base

import android.content.Context
import com.example.android.architecture.blueprints.todoapp.base.interfaces.TasksRepositoryFactory

/**
 * Calls the correct implementation of application based on the manifest or roboletric properties
 */
fun Context.getTasksRepository() =
    (applicationContext as TasksRepositoryFactory).tasksRepository
